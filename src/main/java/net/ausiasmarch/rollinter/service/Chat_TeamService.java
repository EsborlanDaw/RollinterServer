package net.ausiasmarch.rollinter.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.Chat_TeamEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.UsertypeHelper;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.Chat_TeamRepository;
import net.ausiasmarch.rollinter.exception.ValidationException;

@Service
public class Chat_TeamService {

    private final Chat_TeamRepository oChat_TeamRepository;
    private final AuthService oAuthService;

    @Autowired
    public Chat_TeamService(Chat_TeamRepository oChat_TeamRepository, AuthService oAuthService) {
        this.oChat_TeamRepository = oChat_TeamRepository;
        this.oAuthService = oAuthService;
    }

    public void validate(Long id) {
        if (!oChat_TeamRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    
    public List <Chat_TeamEntity> get(Long id) {
    
            return oChat_TeamRepository.findByTeamId(id);
    }

    public Long count() {
        // oAuthService.OnlyAdmins();
        return oChat_TeamRepository.count();
    }


    public Page<Chat_TeamEntity> getPage(Pageable oPageable, String strFilter, Long id_team, Long id_user) {
        oAuthService.OnlyAdminsOrUsers();
        ValidationHelper.validateRPP(oPageable.getPageSize());
        if (strFilter == null || strFilter.length() == 0) {
            if (id_user == null) {
                if (id_team == null) {
                    return oChat_TeamRepository.findAll(oPageable);
                } else {
                    return oChat_TeamRepository.findByTeamId(id_team, oPageable);
                }
            } else {
                if (id_team == null) {
                    return oChat_TeamRepository.findByUserId(id_user, oPageable);
                } else {
                    return oChat_TeamRepository.findByTeamIdAndUserId(id_team, id_user, oPageable);
                }
            }
        } else {
            if (id_user == null) {
                if (id_team == null) {
                    return oChat_TeamRepository
                            .findByTextchatIgnoreCaseContaining(
                                     strFilter, oPageable);
                } else {
                    return oChat_TeamRepository
                            .findByTextchatIgnoreCaseContainingAndTeamId(
                                     strFilter, id_team, oPageable);
                }
            } else {
                if (id_team == null) {
                    return oChat_TeamRepository
                            .findByTextchatIgnoreCaseContainingAndUserId(
                                     strFilter, id_user, oPageable);
                } else {
                    return oChat_TeamRepository
                            .findByTextchatIgnoreCaseContainingAndTeamIdAndUserId(
                                    strFilter, id_team, id_user, oPageable);
                }
            }
        }

    }

    /*
     * public Long update(Chat_TeamEntity oChat_TeamEntity) {
     * validate(oChat_TeamEntity.getId());
     * oAuthService.OnlyAdmins();
     * return oChat_TeamRepository.save(oChat_TeamEntity).getId();
     * }
     */    


    public Long create(Chat_TeamEntity oNewChat_TeamEntity) {
        oAuthService.OnlyAdminsOrUsers();
       
        oNewChat_TeamEntity.setId(0L);
        oNewChat_TeamEntity.setCreationdate(LocalDateTime.now());
        
        return oChat_TeamRepository.save(oNewChat_TeamEntity).getId();
    }

    

    public Long delete(Long id, Long id_user) {
        oAuthService.OnlyAdminsOrOwnUsersData(id_user);
        
        Chat_TeamEntity oComentEntity = oChat_TeamRepository.getById(id);
        if (oComentEntity.getUser().getId() == id_user || id_user == UsertypeHelper.ADMIN ) {
            oChat_TeamRepository.deleteById(id);
            return id;
            
        } else {
            throw new ResourceNotModifiedException("can't remove register " + id + " because you have not written it");
            
        }
    }

    public Long deleteByTeamId(Long id) {
        oAuthService.OnlyAdminsOrOwnUsersData(id);
        List<Chat_TeamEntity> oChat_TeamEntities = oChat_TeamRepository.findByTeamId(id);

        if (oChat_TeamEntities.size() != 0) {
            for (int i = 0; i < oChat_TeamEntities.size(); i++) {
                oChat_TeamRepository.deleteById(oChat_TeamEntities.get(i).getId());
            }
        }

        return id;

    }

    public Long deleteByUserId(Long id) {
        oAuthService.OnlyAdminsOrOwnUsersData(id);
        List<Chat_TeamEntity> oChat_TeamEntities = oChat_TeamRepository.findByUserId(id);

        if (oChat_TeamEntities.size() != 0) {
            for (int i = 0; i < oChat_TeamEntities.size(); i++) {
                oChat_TeamRepository.deleteById(oChat_TeamEntities.get(i).getId());
            }
        }

        return id;

    }
    
}
