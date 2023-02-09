package net.ausiasmarch.rollinter.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.CommentEntity;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.UsertypeHelper;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.CommentRepository;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.exception.ValidationException;


@Service

public class CommentService {

    @Autowired
    CommentRepository oCommentRepository;

    @Autowired
    UserRepository oUserRepository;

    private final AuthService oAuthService;

    @Autowired
    public CommentService(AuthService oAuthService) {
        
        this.oAuthService = oAuthService;
    }

    public void validate(Long id) {
        if (!oCommentRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    
    public List <CommentEntity> get(Long id) {
    
            return oCommentRepository.findByRouteId(id);
    }

    public Long count() {
        // oAuthService.OnlyAdmins();
        return oCommentRepository.count();
    }

    /* public Page<CommentEntity> getPage(Pageable oPageable, Long strFilter, Long id_user, Long id_route) {
        Page<CommentEntity> oPage = null;
        ValidationHelper.validateRPP(oPageable.getPageSize());
        if (strFilter == null) {
            if (id_user != null) {
                return oCommentRepository.findByUserId(id_user, oPageable);
            } else if (id_route != null) {
                return oCommentRepository.findByRouteId(id_user, oPageable);
            } else {
                return oCommentRepository.findAll(oPageable);
            }
        } else {
            return oCommentRepository.findAll(oPageable);
        }
    } */

    public Page<CommentEntity> getPage(Pageable oPageable, String strFilter, Long id_route, Long id_user) {
        oAuthService.OnlyAdminsOrUsers();
        ValidationHelper.validateRPP(oPageable.getPageSize());
        if (strFilter == null || strFilter.length() == 0) {
            if (id_user == null) {
                if (id_route == null) {
                    return oCommentRepository.findAll(oPageable);
                } else {
                    return oCommentRepository.findByRouteId(id_route, oPageable);
                }
            } else {
                if (id_route == null) {
                    return oCommentRepository.findByUserId(id_user, oPageable);
                } else {
                    return oCommentRepository.findByRouteIdAndUserId(id_route, id_user, oPageable);
                }
            }
        } else {
            if (id_user == null) {
                if (id_route == null) {
                    return oCommentRepository
                            .findByTextIgnoreCaseContaining(
                                     strFilter, oPageable);
                } else {
                    return oCommentRepository
                            .findByTextIgnoreCaseContainingAndRouteId(
                                     strFilter, id_route, oPageable);
                }
            } else {
                if (id_route == null) {
                    return oCommentRepository
                            .findByTextIgnoreCaseContainingAndUserId(
                                     strFilter, id_user, oPageable);
                } else {
                    return oCommentRepository
                            .findByTextIgnoreCaseContainingAndRouteIdAndUserId(
                                    strFilter, id_route, id_user, oPageable);
                }
            }
        }

    }

    /*
     * public Long update(CommentEntity oCommentEntity) {
     * validate(oCommentEntity.getId());
     * oAuthService.OnlyAdmins();
     * return oCommentRepository.save(oCommentEntity).getId();
     * }
     */    


    public Long create(CommentEntity oNewCommentEntity) {
        oAuthService.OnlyAdminsOrUsers();
       
        oNewCommentEntity.setId(0L);
        oNewCommentEntity.setCreationdate(LocalDateTime.now());
        
        return oCommentRepository.save(oNewCommentEntity).getId();
    }

    

    public Long delete(Long id, Long id_user) {
        oAuthService.OnlyAdminsOrOwnUsersData(id_user);
        
        CommentEntity oCommentEntity = oCommentRepository.getById(id);
        UserEntity oUserEntity = oUserRepository.getById(id_user);
        if (oUserEntity.getUsertype().getId() == UsertypeHelper.ADMIN || oCommentEntity.getUser().getId() == oUserEntity.getId()) {
            oCommentRepository.delete(oCommentEntity);
        } 

        if (oCommentRepository.existsById(id)) {
            throw new ResourceNotModifiedException(oCommentEntity.getUser().getId()+ " can't remove register " + id + " because you have not written it " + id_user);
        } else {
            return id;
        } 
    }

    public Long deleteByRouteId(Long id) {
        oAuthService.OnlyAdminsOrOwnUsersData(id);
        List<CommentEntity> oCommentEntities = oCommentRepository.findByRouteId(id);

        if (oCommentEntities.size() != 0) {
            for (int i = 0; i < oCommentEntities.size(); i++) {
                oCommentRepository.deleteById(oCommentEntities.get(i).getId());
            }
        }

        return id;

    }

    public Long deleteByUserId(Long id) {
        oAuthService.OnlyAdminsOrOwnUsersData(id);
        List<CommentEntity> oCommentEntities = oCommentRepository.findByUserId(id);

        if (oCommentEntities.size() != 0) {
            for (int i = 0; i < oCommentEntities.size(); i++) {
                oCommentRepository.deleteById(oCommentEntities.get(i).getId());
            }
        }

        return id;

    }
    
}
