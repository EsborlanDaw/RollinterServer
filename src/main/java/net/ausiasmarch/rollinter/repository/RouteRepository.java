package net.ausiasmarch.rollinter.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.ausiasmarch.rollinter.entity.RouteEntity;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    
}