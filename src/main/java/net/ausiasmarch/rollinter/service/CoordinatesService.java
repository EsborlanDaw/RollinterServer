package net.ausiasmarch.rollinter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.CoordinatesEntity;
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

    public CoordinatesEntity get(Long id) {
        //oAuthService.OnlyAdmins();
        return oCoordinatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coordinates with id: " + id + " not found"));
    }
    
}
