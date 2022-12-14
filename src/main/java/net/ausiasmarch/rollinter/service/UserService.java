package net.ausiasmarch.rollinter.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.TeamEntity;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.repository.TeamRepository;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.repository.UsertypeRepository;
import net.ausiasmarch.rollinter.exception.CannotPerformOperationException;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.RandomHelper;
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
    private final String ROLLINTER_DEFAULT_PASSWORD = "Rollinter2022";
    private final Long ROLLINTER_DEFAULT_TEAM = (long) 1;
    private final List<String> names = List.of("Ainhoa", "Kevin", "Estefania", "Cristina",
            "Jose Maria", "Lucas Ezequiel", "Carlos", "Elliot", "Alexis", "Ruben", "Luis Fernando", "Karim", "Luis",
            "Jose David", "Nerea", "Ximo", "Iris", "Alvaro", "Mario", "Raimon");

    private final List<String> surnames1 = List.of("Benito", "Blanco", "Boriko", "Carrascosa", "Guerrero", "Gyori",
            "Lazaro", "Luque", "Perez", "Perez", "Perez", "Rezgaoui", "Rodríguez", "Rosales", "Soler", "Soler", "Suay", "Talaya", "Tomas", "Vilar");

    private final List<String> surnames2 = List.of("Sanchis", "Bañuls", "Laenos", "Torres", "Sanchez", "Gyori",
            "Luz", "Pascual", "Blayimir", "Castello", "Hurtado", "Mourad", "Fernández", "Ríos", "Benavent", "Benavent", "Patricio", "Romance", "Zanon", "Morera");
    
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
        ValidationHelper.validateYears(oUserEntity.getDatebirth());
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
        //oAuthService.OnlyAdmins();
        UserEntity oOldUserEntity=oUserRepository.getById(oUserEntity.getId());
        oUserEntity.setPassword(oOldUserEntity.getPassword());
        return oUserRepository.save(oUserEntity).getId();
    }

    public Long create(UserEntity oNewUserEntity) {
        //oAuthService.OnlyAdmins();
        validate(oNewUserEntity);
        oNewUserEntity.setId(0L);
        oNewUserEntity.setPassword(ROLLINTER_DEFAULT_PASSWORD);
        TeamEntity oTeamEntity = oTeamRepository.getById(ROLLINTER_DEFAULT_TEAM);
        oNewUserEntity.setTeam(oTeamEntity);
        return oUserRepository.save(oNewUserEntity).getId();
    }

    public Long delete(Long id) {
        //oAuthService.OnlyAdmins();
        validate(id);
        oUserRepository.deleteById(id);
        if (oUserRepository.existsById(id)) {
            throw new ResourceNotModifiedException("can't remove register " + id);
        } else {
            return id;
        }
    }
/* 
    //necesario para coger el id para el generate del team 
    public UserEntity getOneRandom() {
        if (count() > 0) {
            UserEntity oUserEntity = null;
            int iPosicion = RandomHelper.getRandomInt(0, (int) oUserRepository.count() - 1);
            Pageable oPageable = PageRequest.of(iPosicion, 1);
            Page<UserEntity> UserPage = oUserRepository.findAll(oPageable);
            List<UserEntity> UserList = UserPage.getContent();
            oUserEntity = oUserRepository.getById(UserList.get(0).getId());
            return oUserEntity;
        } else {
            throw new CannotPerformOperationException("ho hay usuarios en la base de datos");
        }
    }

    private UserEntity generateUser() {
        UserEntity oUserEntity = new UserEntity();

        oUserEntity.setName(names.get(RandomHelper.getRandomInt(0, names.size() - 1)));
        oUserEntity.setSurname1(surnames1.get(RandomHelper.getRandomInt(0, names.size() - 1)));
        oUserEntity.setSurname2(surnames2.get(RandomHelper.getRandomInt(0, names.size() - 1)));
        
        oUserEntity.setUsername((oUserEntity.getName().toLowerCase()
                + oUserEntity.getSurname1().toLowerCase()).replaceAll("\\s", ""));
        oUserEntity.setEmail(oUserEntity.getUsername() + "@rollinter.net");

        oUserEntity.setPassword(ROLLINTER_DEFAULT_PASSWORD);

        int totalUsertypes = (int) oUsertypeRepository.count();
        int randomUserTypeId = RandomHelper.getRandomInt(1, totalUsertypes);
        oUsertypeRepository.findById((long) randomUserTypeId)
                .ifPresent(oUserEntity::setUsertype);

        int totalTeams = (int) oTeamRepository.count();
        int randomTeamId = RandomHelper.getRandomInt(1, totalTeams);
        oTeamRepository.findById((long) randomTeamId)
                .ifPresent(oUserEntity::setTeam);

        return oUserEntity;
    }

    public UserEntity generateOne() {
        //oAuthService.OnlyAdmins();
        return oUserRepository.save(generateUser());
    }

    public Long generateSome(Long amount) {
        //oAuthService.OnlyAdmins();
        List<UserEntity> UserToSave = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            UserToSave.add(generateUser());
        }
        oUserRepository.saveAll(UserToSave);
        return oUserRepository.count();
    }*/
}
