package net.ausiasmarch.rollinter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import net.ausiasmarch.rollinter.entity.RouteEntity;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    public List <RouteEntity> findAll();

    RouteEntity findByUserId(Long id_user);

    RouteEntity findByNameContainingIgnoreCase(String strFilter);

    Page<RouteEntity> findByUserId(Long id_user, Pageable oPageable);

    Page<RouteEntity> findByUserIdAndNameIgnoreCase(Long id_user, String strFilter, Pageable oPageable);

    Page<RouteEntity> findByNameContainingIgnoreCase(String strFilter, Pageable oPageable);
    
}