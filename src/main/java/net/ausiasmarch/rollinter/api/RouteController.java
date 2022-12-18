package net.ausiasmarch.rollinter.api;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.rollinter.entity.RouteEntity;
import net.ausiasmarch.rollinter.service.RouteService;

import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService oRouteService;

    @GetMapping("/{id}")
    public ResponseEntity<RouteEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<RouteEntity>(oRouteService.get(id), HttpStatus.OK);
    }
    
}
