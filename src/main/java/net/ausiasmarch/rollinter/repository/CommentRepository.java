package net.ausiasmarch.rollinter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.rollinter.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByRouteId(Long id);

    Page<CommentEntity> findByUserId(Long id_user, Pageable oPageable);

    Page<CommentEntity> findByRouteId(Long id_user, Pageable oPageable);

    CommentEntity findByRouteIdAndUserId(Long id_route, Long id_user);

    List<CommentEntity> findByUserId(Long id);

    Page<CommentEntity> findByTextIgnoreCaseContaining(String strFilter,
            Pageable oPageable);

    Page<CommentEntity> findByRouteIdAndUserId(Long id_route, Long id_user, Pageable oPageable);

    Page<CommentEntity> findByTextIgnoreCaseContainingAndRouteId(String strFilter,
             Long id_route, Pageable oPageable);

    Page<CommentEntity> findByTextIgnoreCaseContainingAndUserId(String strFilter,
             Long id_user, Pageable oPageable);

    Page<CommentEntity> findByTextIgnoreCaseContainingAndRouteIdAndUserId(String strFilter,
             Long id_route, Long id_user, Pageable oPageable);
    
}
