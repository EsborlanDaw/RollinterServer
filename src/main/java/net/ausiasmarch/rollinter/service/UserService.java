package net.ausiasmarch.rollinter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.repository.TeamRepository;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.repository.UsertypeRepository;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.exception.ValidationException;


@Service
public class UserService {

    @Autowired
    UsertypeService oUsertypeService;

    @Autowired
    TeamService oTeamService;

    private final UsertypeRepository oUsertypeRepository;
    private final UserRepository oUserRepository;
    private final AuthService oAuthService;
    private final TeamRepository oTeamRepository;

    @Autowired
    public UserService(UserRepository oUserRepository, TeamRepository oTeamRepository, UsertypeRepository oUsertypeRepository, AuthService oAuthService){
        this.oUserRepository = oUserRepository;
        this.oTeamRepository = oTeamRepository;
        this.oUsertypeRepository = oUsertypeRepository;
        this.oAuthService = oAuthService;
    }

    public void validate(Long id) {
        if (!oUserRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    public void validate(UserEntity oUserEntity) {
        ValidationHelper.validateStringLength(oUserEntity.getName(), 2, 50, "campo name de User(el campo debe tener longitud de 2 a 50 caracteres)");
        ValidationHelper.validateStringLength(oUserEntity.getSurname1(), 2, 50, "campo surname de User(el campo debe tener longitud de 2 a 50 caracteres)");
        ValidationHelper.validateStringLength(oUserEntity.getSurname2(), 2, 50, "campo lastname de User(el campo debe tener longitud de 2 a 50 caracteres)");
        ValidationHelper.validateEmail(oUserEntity.getEmail(), "campo email de User");
        ValidationHelper.validateLogin(oUserEntity.getUsername(), "campo username de User");
        if (oUserRepository.existsByUsername(oUserEntity.getUsername())) {
            throw new ValidationException("el campo username está repetido");
        }
        oUsertypeService.validate(oUserEntity.getUsertype().getId());
        
    }

    public UserEntity get (Long id) {
        //oAuthService.OnlyAdminsOrOwnUsersData(id);
        return oUserRepository.findById(id).get();
        //.orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
    }

    public Page<UserEntity> getPage(Pageable oPageable, String strFilter, Long id_team, Long id_usertype) {
        //oAuthService.OnlyAdmins();
        ValidationHelper.validateRPP(oPageable.getPageSize());
        if (strFilter == null || strFilter.length()==0) {
            if (id_team == null) {
                if (id_usertype == null) {
                    return oUserRepository.findAll(oPageable);
                } else {
                    return oUserRepository.findByUsertypeId(id_usertype, oPageable);
                }
            } else {
                if (id_usertype == null) {
                    return oUserRepository.findByTeamId(id_team, oPageable);
                } else {
                    return oUserRepository.findByTeamIdAndUsertypeId(id_team, id_usertype, oPageable);
                }
            }
        } else {
            if (id_team == null) {
                if (id_usertype == null) {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContaining(strFilter, strFilter, strFilter, oPageable);
                } else {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndUsertypeId(strFilter, strFilter, strFilter, id_usertype, oPageable);
                }
            } else {
                if (id_usertype == null) {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndTeamId(strFilter, strFilter, strFilter, id_team, oPageable);
                } else {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndTeamIdAndUsertypeId(strFilter, strFilter, strFilter, id_team, id_usertype, oPageable);
                }
            }
        }

    }

    public Long count() {
        //oAuthService.OnlyAdmins();
        return oUserRepository.count();
    }

    public Long update(UserEntity oUserEntity) {
        validate(oUserEntity.getId());
        oAuthService.OnlyAdminsOrOwnUsersData(oUserEntity.getId());
        return oUserRepository.save(oUserEntity).getId();
    }

    public Long create(UserEntity oNewUserEntity) {
        //oAuthService.OnlyAdmins();
        validate(oNewUserEntity);
        oNewUserEntity.setId(0L);
        return oUserRepository.save(oNewUserEntity).getId();
    }

    public Long delete(Long id) {
        //oAuthService.OnlyAdminsOrOwnUsersData(id);
        validate(id);
        oUserRepository.deleteById(id);
        if (oUserRepository.existsById(id)) {
            throw new ResourceNotModifiedException("can't remove register " + id);
        } else {
            return id;
        }
    }
}
