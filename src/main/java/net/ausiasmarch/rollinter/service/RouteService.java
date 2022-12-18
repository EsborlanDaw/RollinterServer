package net.ausiasmarch.rollinter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.RouteEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.RouteRepository;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.exception.ValidationException;


@Service
public class RouteService {

    private final RouteRepository oRouteRepository;
    private final AuthService oAuthService;

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    UserService oUserService;

    @Autowired
    public RouteService(RouteRepository oRouteRepository, AuthService oAuthService) {
        this.oRouteRepository = oRouteRepository;
        this.oAuthService = oAuthService;
    }

    public RouteEntity get(Long id) {
        //oAuthService.OnlyAdmins();
        return oRouteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route with id: " + id + " not found"));
    }
    
}
