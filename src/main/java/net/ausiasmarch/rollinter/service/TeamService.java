package net.ausiasmarch.rollinter.service;

import net.ausiasmarch.rollinter.entity.TeamEntity;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ValidationException;
import net.ausiasmarch.rollinter.helper.RandomHelper;
import net.ausiasmarch.rollinter.helper.UsertypeHelper;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.repository.TeamRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class TeamService {

    private final TeamRepository oTeamRepository;
    private final AuthService oAuthService;
    private final List<String> names = List.of("eros", "azos", "pleyers", "simple",
            "star", "team", "phisical", "danger", "trios", "metal", "roll");

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    UserService oUserService;

    @Autowired
    Chat_TeamService oChat_TeamService;

    @Autowired
    public TeamService(TeamRepository oTeamRepository, AuthService oAuthService) {
        this.oTeamRepository = oTeamRepository;
        this.oAuthService = oAuthService;
    }

    public TeamEntity get(Long id) {
        // oAuthService.OnlyAdmins();
        try {
            return oTeamRepository.findById(id).get();
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Id " + id + " not exist");
        }
    }

    public void validate(TeamEntity oTeamEntity) {
        ValidationHelper.validateStringLength(oTeamEntity.getName(), 2, 50,
                "campo name: (el campo debe tener longitud de 2 a 50 caracteres y no tener espacios)");
        if(oTeamRepository.existsByName(oTeamEntity.getName())){
            throw new ValidationException("Name exists, choose another name");
        }

    }

    public void validate(Long id) {
        if (!oTeamRepository.existsById(id)) {
            throw new ValidationException("Id " + id + " not exist");
        }
    }

    public Long delete(Long id) {
        oAuthService.OnlyAdmins();
        validate(id);
        oUserService.updateTeam(oTeamRepository.getById(id));
        oChat_TeamService.deleteByTeamId(id);
        oTeamRepository.deleteById(id);
        if (oTeamRepository.existsById(id)) {
            throw new ValidationException("Can't remove register " + id);
        } else {
            return id;
        }
    }

    public Long deleteByUser(Long id, Long id_user) {

        TeamEntity oTeamEntity = oTeamRepository.getById(id);
        UserEntity oUserEntity = oUserRepository.getById(id_user);
        if (oUserEntity.getUsertype().getId() == UsertypeHelper.ADMIN || oTeamEntity.getUser() == oUserEntity.getId()) {
            oUserService.updateTeam(oTeamRepository.getById(id));
            oChat_TeamService.deleteByTeamId(id);
            oTeamRepository.deleteById(oTeamEntity.getId());
        } 

        if (oTeamRepository.existsById(id)) {
            throw new ValidationException(oTeamEntity.getUser()+ " can't remove register " + id + " because you have not written it " + id_user);
        } else {
            return id;
        } 
    }

    public void deleteEmptyTeam (TeamEntity oTeamEntity) {

        if (oTeamEntity.getUsers() == 0 && oTeamEntity.getId() != 1 )
        {
            delete(oTeamEntity.getId());
        }

    }

    public Page<TeamEntity> getPage(Pageable oPageable, String strFilter, Long lUser) {
        Page<TeamEntity> oPage = null;
        oAuthService.OnlyAdminsOrUsers();
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

    }

    public Long create(TeamEntity oNewTeamEntity) {

        UserEntity oUserEntity = oUserRepository.getById(oNewTeamEntity.getUser());

        if (oTeamRepository.getByUserId(oUserEntity.getId()) != null && oUserEntity.getUsertype().getId() != UsertypeHelper.ADMIN){
            throw new ValidationException("You are already in a team, if you want you can change your team in your profile");
        } else{
        oAuthService.OnlyAdminsOrUsers();
        validate(oNewTeamEntity);
        oNewTeamEntity.setCreationdate(LocalDateTime.now());
        oTeamRepository.save(oNewTeamEntity);
        oTeamRepository.getByUserId(oNewTeamEntity.getUser()).getUser();
        oUserEntity.setTeam(oNewTeamEntity);
        oUserRepository.save(oUserEntity);
        return oNewTeamEntity.getId();
        }
    }

    public Long count() {
        // oAuthService.OnlyAdmins();
        return oTeamRepository.count();
    }

    public Long update(TeamEntity oTeamEntity) {
        oAuthService.OnlyAdmins();
        validate(oTeamEntity.getId());
        TeamEntity oOldTeamEntity = oTeamRepository.getById(oTeamEntity.getId());
        oTeamEntity.setUser(oUserRepository.getById(oOldTeamEntity.getUser()));
        return oTeamRepository.save(oTeamEntity).getId();
    }

    public List<TeamEntity> teams() {

        List<TeamEntity> teams = oTeamRepository.findAll();

        return teams;
    }

    // necesario para coger el id para el generate del team
    public TeamEntity getOneRandom() {
        if (count() > 0) {
            TeamEntity oTeamEntity = null;
            int iPosicion = RandomHelper.getRandomInt(0, (int) oTeamRepository.count() - 1);
            Pageable oPageable = PageRequest.of(iPosicion, 1);
            Page<TeamEntity> TeamPage = oTeamRepository.findAll(oPageable);
            List<TeamEntity> TeamList = TeamPage.getContent();
            oTeamEntity = oTeamRepository.getById(TeamList.get(0).getId());
            return oTeamEntity;
        } else {
            throw new ValidationException("There is not user in data base");
        }
    }

    private TeamEntity generateTeam() {

        oAuthService.OnlyAdmins();
        TeamEntity oTeamEntity = new TeamEntity();

        oTeamEntity.setName("Roll" + names.get(RandomHelper.getRandomInt(0, names.size() - 1)) + ""
                + RandomHelper.getRandomInt(0, 300000));

        List<UserEntity> user = oUserService.users();

        oTeamEntity.setCreationdate(LocalDateTime.now());

        oTeamEntity.setUser(user.get(RandomHelper.getRandomInt(0, user.size() - 1)));

        oTeamRepository.save(oTeamEntity);

        UserEntity oUserEntity = (oUserRepository.getById(oTeamEntity.getUser()));
        oUserEntity.setTeam(oTeamEntity);
        oUserRepository.save(oUserEntity);

        List<UserEntity> users = oUserService.users();
        int total = RandomHelper.getRandomInt(0, users.size() - 1);
        
        for (int i = 0; i < total; i++) {
            users = oUserService.users();
            UserEntity userteam = (users.get(RandomHelper.getRandomInt(0, total)));

            userteam.setTeam(oTeamEntity);
            oUserRepository.save(oUserEntity);
            total--;
            
        }

        return oTeamEntity;
    }

    public TeamEntity generateOne() {
        // oAuthService.OnlyAdmins();
        return oTeamRepository.save(generateTeam());
    }

    public Long generateSome(Long amount) {
        oAuthService.OnlyAdmins();
        List<UserEntity> users = oUserService.users();
        int total = users.size();
        if (total >= amount) {

            for (int i = 0; i < amount; i++) {
                generateTeam();
            }

        } else {
            throw new ValidationException(
                    "There is enough users in data base to create " + amount + " teams");
        }

        return oTeamRepository.count();
    }

}
