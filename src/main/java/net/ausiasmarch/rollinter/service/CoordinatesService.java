package net.ausiasmarch.rollinter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.CoordinatesEntity;
import net.ausiasmarch.rollinter.entity.RouteEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.CoordinatesRepository;
import net.ausiasmarch.rollinter.repository.RouteRepository;
import net.ausiasmarch.rollinter.exception.ValidationException;

import net.ausiasmarch.rollinter.repository.RouteRepository;

@Service
public class CoordinatesService {

    private final CoordinatesRepository oCoordinatesRepository;
    private final AuthService oAuthService;

    @Autowired
    RouteRepository oRouteRepository;

    @Autowired
    RouteService oRouteService;

    public CoordinatesService(CoordinatesRepository oCoordinatesRepository, AuthService oAuthService) {
        this.oCoordinatesRepository = oCoordinatesRepository;
        this.oAuthService = oAuthService;
    }

    public void validate(Long id) {
        if (!oCoordinatesRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    public void validate(CoordinatesEntity oCoordinatesEntity) {
        // Validar dificultad y tiempo

    }

   

    public Long count() {
        // oAuthService.OnlyAdmins();
        return oCoordinatesRepository.count();
    }

    public Page<CoordinatesEntity> getPage(Pageable oPageable, String strFilter, Long lRoute) {
        Page<CoordinatesEntity> oPage = null;
        // if (oAuthService.isAdmin()) {
        if (lRoute != null) {

            return oCoordinatesRepository.findByRouteId(lRoute, oPageable);

        } else {
            return oCoordinatesRepository.findAll(oPageable);
        }

    }

    public Long update(CoordinatesEntity oCoordinatesEntity) {
        validate(oCoordinatesEntity.getId());
        // oAuthService.OnlyAdmins();
        return oCoordinatesRepository.save(oCoordinatesEntity).getId();
    }

    public Long create(CoordinatesEntity oNewCoordinatesEntity) {
        // oAuthService.OnlyAdmins();
        List<RouteEntity> routes = oRouteRepository.findAll();
        // Para crear una ruta tienes que introducir coordenadas
        validate(oNewCoordinatesEntity);
        oNewCoordinatesEntity.setId(0L);
        oNewCoordinatesEntity.setRoute(routes.get(routes.size() - 1));
        return oCoordinatesRepository.save(oNewCoordinatesEntity).getId();
    }

    public Long createMultiple( List <CoordinatesEntity> oNewCoordinatesEntity) {
        /* // oAuthService.OnlyAdmins();
        RouteEntity route = oRouteRepository.getById(id);
        // Para crear una ruta tienes que introducir coordenadas
        for (int i = 0; i < oNewCoordinatesEntity.size(); i++) {
            oNewCoordinatesEntity.get(i).setId(0L);
            oNewCoordinatesEntity.get(i).setRoute(route);
        } */
        
        return  (long)(oCoordinatesRepository.saveAll(oNewCoordinatesEntity).size());
    }

    public void delete(Long id) {
        // oAuthService.OnlyAdmins();
    
        List <CoordinatesEntity> coordi = new ArrayList();

        if(oCoordinatesRepository.existsByRouteId(id)){
            coordi = oCoordinatesRepository.findByRouteId(id);
        for ( int i = 0 ; i < coordi.size(); i++)
        {    
            oCoordinatesRepository.deleteById(coordi.get(i).getId());
        }
        }

    }

}
