package net.ausiasmarch.rollinter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.rollinter.entity.Chat_TeamEntity;

public interface Chat_TeamRepository extends JpaRepository<Chat_TeamEntity, Long> {
    
}
