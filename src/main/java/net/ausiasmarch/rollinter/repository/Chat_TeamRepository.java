package net.ausiasmarch.rollinter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.rollinter.entity.Chat_TeamEntity;

public interface Chat_TeamRepository extends JpaRepository<Chat_TeamEntity, Long> {

    List<Chat_TeamEntity> findByTeamId(Long id);

    Page<Chat_TeamEntity> findByTeamId(Long id_team, Pageable oPageable);

    Page<Chat_TeamEntity> findByUserId(Long id_user, Pageable oPageable);

    Page<Chat_TeamEntity> findByTeamIdAndUserId(Long id_team, Long id_user, Pageable oPageable);

    Page<Chat_TeamEntity> findByTextchatIgnoreCaseContaining(String strFilter, Pageable oPageable);

    Page<Chat_TeamEntity> findByTextchatIgnoreCaseContainingAndTeamId(String strFilter, Long id_team,
            Pageable oPageable);

    Page<Chat_TeamEntity> findByTextchatIgnoreCaseContainingAndUserId(String strFilter, Long id_user,
            Pageable oPageable);

    Page<Chat_TeamEntity> findByTextchatIgnoreCaseContainingAndTeamIdAndUserId(String strFilter, Long id_team, Long id_user,
            Pageable oPageable);

    List<Chat_TeamEntity> findByUserId(Long id);
    
}
