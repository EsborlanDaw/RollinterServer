package net.ausiasmarch.rollinter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.rollinter.entity.CoordinatesEntity;

public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity, Long> {

    boolean existsByRouteId(Long id_route);

    public List <CoordinatesEntity> findByRouteId(Long lRoute);

    Page<CoordinatesEntity> findByRouteId(Long lRoute, Pageable oPageable);
    
}
