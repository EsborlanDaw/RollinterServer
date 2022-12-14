package net.ausiasmarch.rollinter.repository;

import net.ausiasmarch.rollinter.entity.TeamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    Page<TeamEntity> findAll(Pageable oPageable);

    Page<TeamEntity> findByUserIdAndNameContainingIgnoreCase(long lUser, String strFilter, Pageable oPageable);

    Page<TeamEntity> findByNameContainingIgnoreCase(String strFilter, Pageable oPageable);

    Page<TeamEntity> findByUserId(long lUser, Pageable oPageable);

}
