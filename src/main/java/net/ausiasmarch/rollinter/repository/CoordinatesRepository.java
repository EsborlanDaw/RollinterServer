package net.ausiasmarch.rollinter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.rollinter.entity.CoordinatesEntity;

public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity, Long> {
    
}
