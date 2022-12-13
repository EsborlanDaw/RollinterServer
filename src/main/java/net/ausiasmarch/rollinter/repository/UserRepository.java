package net.ausiasmarch.rollinter.repository;
import net.ausiasmarch.rollinter.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUsername(String username);

    UserEntity findByUsernameAndPassword(String username, String password);
    
    UserEntity findByUsername(String username);

    Page<UserEntity> findByTeamIdAndUsertypeId(Long id_team, Long id_usertype, Pageable oPageable);

    Page<UserEntity> findByUsertypeId(Long id_usertype, Pageable oPageable);

    Page<UserEntity> findByTeamId(Long id_team, Pageable oPageable);
                        
    Page<UserEntity> findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContaining(String strFilterName, String strFilterSurname1, String strFilterLast_name, Pageable oPageable);

    Page<UserEntity> findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndUsertypeId(String strFilterName, String strFilterSurname1, String strFilterLast_name, Long id_usertype, Pageable oPageable);

    Page<UserEntity> findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndTeamId(String strFilterName, String strFilterSurname1, String strFilterLast_name, Long id_team, Pageable oPageable);

    Page<UserEntity> findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndTeamIdAndUsertypeId(String strFilterName, String strFilterSurname1, String strFilterLast_name, Long id_team, Long id_usertype, Pageable oPageable);

    
    
}
