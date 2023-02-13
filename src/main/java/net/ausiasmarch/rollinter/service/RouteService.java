package net.ausiasmarch.rollinter.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.RouteEntity;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.exception.CannotPerformOperationException;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.RandomHelper;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.RouteRepository;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.exception.ValidationException;


@Service
public class RouteService {

    private final RouteRepository oRouteRepository;
    private final AuthService oAuthService;

    private final List<String> dificulty = List.of("Easy", "Medium", "Hard");

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    UserService oUserService;

    @Autowired
    CoordinatesService oCoordinatesService;
    
    @Autowired
    ReactionService oReactionService;

    @Autowired
    CommentService oCommentService;

    @Autowired
    public RouteService(RouteRepository oRouteRepository, AuthService oAuthService) {
        this.oRouteRepository = oRouteRepository;
        this.oAuthService = oAuthService;
    }

    public void validate(Long id) {
        if (!oRouteRepository.existsById(id)) {
            throw new ValidationException("id " + id + " not exist");
        }
    }

    public void validate(RouteEntity oRouteEntity) {
        //Validar dificultad y tiempo
        ValidationHelper.validateStringLength(oRouteEntity.getName(), 2, 50, "campo name de Route(el campo debe tener longitud de 2 a 50 caracteres)");
        
    }

    public RouteEntity get(Long id) {
        return oRouteRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Route with id: " + id + " not found"));
    }

    public Long count() {
        //oAuthService.OnlyAdmins();
        return oRouteRepository.count();
    }

    public Page<RouteEntity> getPage(Pageable oPageable, String strFilter, Long id_user) {
        Page<RouteEntity> oPage = null;
        ValidationHelper.validateRPP(oPageable.getPageSize());
        if (strFilter == null || strFilter.length() == 0) {
            if (id_user == null) {
                    return oRouteRepository.findAll(oPageable);
                } else {
                    return oRouteRepository.findByUserId(id_user, oPageable);
            }
            } else if (strFilter != null || strFilter.length() != 0) {
                return oRouteRepository.findByNameContainingIgnoreCaseOrDificultyContainingIgnoreCase(strFilter, strFilter, oPageable);
            }else {
                return oRouteRepository.findAll(oPageable);
            }
    }



    public Long update(RouteEntity oRouteEntity) {
        validate(oRouteEntity.getId());
        oAuthService.OnlyAdmins();
        return oRouteRepository.save(oRouteEntity).getId();
    }

    public Long create(RouteEntity oNewRouteEntity) {
        oAuthService.OnlyAdminsOrUsers();
        //Para crear una ruta tienes que introducir coordenadas
        
        oNewRouteEntity.setId(0L);
        validate(oNewRouteEntity);
        return oRouteRepository.save(oNewRouteEntity).getId();
    }

    public Long delete(Long id) {
        oAuthService.OnlyAdminsOrOwnUsersData(id);
        validate(id);
        oCoordinatesService.delete(id);
        oReactionService.deleteByRouteId(id);
        oCommentService.deleteByRouteId(id);
        oRouteRepository.deleteById(id);
        if (oRouteRepository.existsById(id)) {
            throw new ValidationException("can't remove register " + id);
        } else {
            return id;
        }
    }

    


    private RouteEntity generateRoute() {

        oAuthService.OnlyAdmins();
        RouteEntity oRouteEntity = new RouteEntity();

        oRouteEntity.setName("Rollroute"+ RandomHelper.getRandomInt(0, 300000));

        List<UserEntity> user = oUserRepository.findAll();

        oRouteEntity.setDificulty(dificulty.get(RandomHelper.getRandomInt(0, dificulty.size() - 1)));

        oRouteEntity.setTime(RandomHelper.getRandomInt(0, 2) + ":" + RandomHelper.getRandomInt(0, 59) + ":00");

        oRouteEntity.setUser(user.get(RandomHelper.getRandomInt(0, user.size() - 1)));

        oRouteRepository.save(oRouteEntity);

        oCoordinatesService.generateCoordinates(oRouteEntity);
        
        return oRouteEntity;
    }

   

    public Long generateSome(Long amount) {
        oAuthService.OnlyAdmins();
        List<UserEntity> users = oUserRepository.findAll();
        int total = users.size();
        if (total >= amount) {

        for (int i = 0; i < amount; i++) {
                generateRoute();
        }

        } else {
            throw new ValidationException(
                    "There is enough users in data base to create " + amount + " routes");
        }

        return oRouteRepository.count();
    }
    
}
