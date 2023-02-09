package net.ausiasmarch.rollinter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.rollinter.entity.ReactionEntity;


public interface ReactionRepository extends JpaRepository<ReactionEntity, Long> {

   
     Page<ReactionEntity> findByUserId(Long id_user, Pageable oPageable);

     public ReactionEntity findByRouteIdAndUserId(Long id_route, Long id_user);

    public List <ReactionEntity> findByRouteId(Long id);

    public List <ReactionEntity> findByUserId(Long id);

    Page<ReactionEntity> findByRouteId(Long id_route, Pageable oPageable);

    Page<ReactionEntity> findByRouteIdAndUserId(Long id_route, Long id_user, Pageable oPageable);

    Page<ReactionEntity> findByLikenumber(String strFilter, Pageable oPageable);

    Page<ReactionEntity> findByLikenumberAndRouteId(String strFilter, Long id_route, Pageable oPageable);

    Page<ReactionEntity> findByLikenumberAndUserId(String strFilter, Long id_user, Pageable oPageable);

    Page<ReactionEntity> findByLikenumberAndRouteIdAndUserId(String strFilter, Long id_route, Long id_user,
            Pageable oPageable);
    
}
