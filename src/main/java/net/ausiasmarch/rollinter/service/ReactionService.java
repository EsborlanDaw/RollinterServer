package net.ausiasmarch.rollinter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.ReactionEntity;
import net.ausiasmarch.rollinter.entity.RouteEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.ReactionRepository;
import net.ausiasmarch.rollinter.repository.RouteRepository;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.exception.ValidationException;

@Service
public class ReactionService {

    private final ReactionRepository oReactionRepository;
    private final AuthService oAuthService;

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    RouteRepository oRouteRepository;

    @Autowired
    public ReactionService(ReactionRepository oReactionRepository, AuthService oAuthService) {
        this.oReactionRepository = oReactionRepository;
        this.oAuthService = oAuthService;
    }

    public void validate(Long id) {
        if (!oReactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    /*
     * public void validate(ReactionEntity oReactionEntity) {
     * //Validar dificultad y tiempo
     * ValidationHelper.validateStringLength(oReactionEntity., 2, 50,
     * "campo name de Reaction(el campo debe tener longitud de 2 a 50 caracteres)");
     * 
     * }
     */
    public Long get(Long id) {
        List<ReactionEntity> likes = oReactionRepository.findByRouteId(id);

        if (likes.size() != 0) {
            return (long) likes.size();
        } else {
            return (long) 0;
        }

    }

    public Long count() {
        // oAuthService.OnlyAdmins();
        return oReactionRepository.count();
    }

    public Page<ReactionEntity> getPage(Pageable oPageable, String strFilter, Long id_route, Long id_user) {
        oAuthService.OnlyAdminsOrUsers();
        ValidationHelper.validateRPP(oPageable.getPageSize());
        if (strFilter == null || strFilter.length() == 0) {
            if (id_user == null) {
                if (id_route == null) {
                    return oReactionRepository.findAll(oPageable);
                } else {
                    return oReactionRepository.findByRouteId(id_route, oPageable);
                }
            } else {
                if (id_route == null) {
                    return oReactionRepository.findByUserId(id_user, oPageable);
                } else {
                    return oReactionRepository.findByRouteIdAndUserId(id_route, id_user, oPageable);
                }
            }
        } else {
            if (id_user == null) {
                if (id_route == null) {
                    return oReactionRepository
                            .findByLikenumber(
                                     strFilter, oPageable);
                } else {
                    return oReactionRepository
                            .findByLikenumberAndRouteId(
                                     strFilter, id_route, oPageable);
                }
            } else {
                if (id_route == null) {
                    return oReactionRepository
                            .findByLikenumberAndUserId(
                                     strFilter, id_user, oPageable);
                } else {
                    return oReactionRepository
                            .findByLikenumberAndRouteIdAndUserId(
                                    strFilter, id_route, id_user, oPageable);
                }
            }
        }

    }

    /*
     * public Long update(ReactionEntity oReactionEntity) {
     * validate(oReactionEntity.getId());
     * oAuthService.OnlyAdmins();
     * return oReactionRepository.save(oReactionEntity).getId();
     * }
     */    


    public Long create(ReactionEntity oNewReactionEntity) {
        oAuthService.OnlyAdminsOrUsers();
        List<ReactionEntity> reacts = oReactionRepository.findByRouteId(oNewReactionEntity.getRoute().getId());
        // Almacenar Reaction
        ReactionEntity oReactionEntity = oReactionRepository.findByRouteIdAndUserId(oNewReactionEntity.getRoute().getId(), oNewReactionEntity.getUser().getId());
        
        
        if( oReactionEntity == null){
        oNewReactionEntity.setId(0L);
        oReactionRepository.save(oNewReactionEntity).getId();
        reacts = oReactionRepository.findByRouteId(oNewReactionEntity.getRoute().getId());
        return (long) reacts.size();
        } else {
            oNewReactionEntity = oReactionRepository.findByRouteIdAndUserId(oNewReactionEntity.getRoute().getId(), oNewReactionEntity.getUser().getId());
            delete(oNewReactionEntity.getId());
            return (long) reacts.size() - 1;
        }

    }

    

    public Long delete(Long id) {
        oAuthService.OnlyAdminsOrUsers();
        validate(id);
        if (!oReactionRepository.existsById(id)) {
            throw new ResourceNotModifiedException("can't remove register " + id);
        } else {
            oReactionRepository.deleteById(id);
            return id;
        }
    }

    public Long deleteByRouteId(Long id) {
        
        List<ReactionEntity> oReactionEntities = oReactionRepository.findByRouteId(id);

        if (oReactionEntities.size() != 0) {
            for (int i = 0; i < oReactionEntities.size(); i++) {
                oReactionRepository.deleteById(oReactionEntities.get(i).getId());
            }
        }

        return id;

    }

    public Long deleteByUserId(Long id) {
        oAuthService.OnlyAdminsOrOwnUsersData(id);
        List<ReactionEntity> oReactionEntities = oReactionRepository.findByUserId(id);

        if (oReactionEntities.size() != 0) {
            for (int i = 0; i < oReactionEntities.size(); i++) {
                oReactionRepository.deleteById(oReactionEntities.get(i).getId());
            }
        }

        return id;

    }

}
