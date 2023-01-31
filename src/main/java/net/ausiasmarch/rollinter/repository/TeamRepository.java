package net.ausiasmarch.rollinter.repository;

import net.ausiasmarch.rollinter.entity.TeamEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    public List <TeamEntity> findAll();
    public TeamEntity  getByUserId(long lUser);
    public TeamEntity existsByUserId(long lUser);
    Page<TeamEntity> findAll(Pageable oPageable);

    Page<TeamEntity> findByUserIdAndNameContainingIgnoreCase(long lUser, String strFilter, Pageable oPageable);

    Page<TeamEntity> findByNameContainingIgnoreCase(String strFilter, Pageable oPageable);

    Page<TeamEntity> findByUserId(long lUser, Pageable oPageable);

}
