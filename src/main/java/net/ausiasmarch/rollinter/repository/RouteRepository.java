package net.ausiasmarch.rollinter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import net.ausiasmarch.rollinter.entity.RouteEntity;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    Page<RouteEntity> findByUserId(Long id_user, Pageable oPageable);

    Page<RouteEntity> findByUserIdAndNameIgnoreCase(Long id_user, String strFilter, Pageable oPageable);

    Page<RouteEntity> findByNameContainingIgnoreCase(String strFilter, Pageable oPageable);
    
}