package net.ausiasmarch.rollinter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.rollinter.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    
}
