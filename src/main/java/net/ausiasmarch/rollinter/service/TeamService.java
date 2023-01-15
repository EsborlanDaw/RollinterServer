package net.ausiasmarch.rollinter.service;

import net.ausiasmarch.rollinter.entity.TeamEntity;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.repository.TeamRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository oTeamRepository;
    private final AuthService oAuthService;


    @Autowired
    UserRepository oUserRepository;

    @Autowired
    UserService oUserService;

    @Autowired
    public TeamService(TeamRepository oTeamRepository, AuthService oAuthService) {
        this.oTeamRepository = oTeamRepository;
        this.oAuthService = oAuthService;
    }

    public TeamEntity get(Long id) {
        //oAuthService.OnlyAdmins();
        return oTeamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with id: " + id + " not found"));
    }

    public void validate(Long id) {
        if (!oTeamRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    public Long delete(Long id) {
        //oAuthService.OnlyAdmins();
        validate(id); 
        oUserService.updateTeam(oTeamRepository.getById(id));
        oTeamRepository.deleteById(id);oUserRepository.deleteById(id);

        if (oTeamRepository.existsById(id)) {
            throw new ResourceNotModifiedException("can't remove register " + id);
        } else {
            return id;
        }
    }

    public Page<TeamEntity> getPage(Pageable oPageable, String strFilter, Long lUser) {
        Page<TeamEntity> oPage = null;
        //if (oAuthService.isAdmin()) {
            if (lUser != null) {
                if (strFilter == null || strFilter.isEmpty() || strFilter.trim().isEmpty()) {
                    return oTeamRepository.findByUserId(lUser, oPageable);
                } else {
                    return oTeamRepository.findByUserIdAndNameContainingIgnoreCase(lUser, strFilter, oPageable);
                }
            } else {
                if (strFilter == null || strFilter.isEmpty() || strFilter.trim().isEmpty()) {
                    return oTeamRepository.findAll(oPageable);
                } else {
                    return oTeamRepository.findByNameContainingIgnoreCase(strFilter, oPageable);
                }
            }
        /*}
         else {
            throw new UnauthorizedException("this request is only allowed to admin role");
        }*/
    
    }

    public Long create(TeamEntity oNewTeamEntity) {
        //oAuthService.OnlyAdmins();
        oNewTeamEntity.setId(0L);
        return oTeamRepository.save(oNewTeamEntity).getId();
    }

    public Long count() {
        //oAuthService.OnlyAdmins();
        return oTeamRepository.count();
    }

    public Long update(TeamEntity oTeamEntity) {
        validate(oTeamEntity.getId());
        //oAuthService.OnlyAdmins();
        return oTeamRepository.save(oTeamEntity).getId();
    }

    public List <TeamEntity> teams (){

        List <TeamEntity> teams = oTeamRepository.findAll();

        return teams;
    }
    

}
