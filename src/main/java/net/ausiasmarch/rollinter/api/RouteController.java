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

    @GetMapping("/")
    public ResponseEntity<Page<RouteEntity>> getPage(
            @ParameterObject @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable oPageable,
            @RequestParam(name = "filter", required = false) String strFilter,
            @RequestParam(value = "user", required = false) Long id_user) {
        return new ResponseEntity<>(oRouteService.getPage(oPageable, strFilter, id_user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<RouteEntity>(oRouteService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oRouteService.count(), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody RouteEntity oRouteEntity) {
        return new ResponseEntity<Long>(oRouteService.update(oRouteEntity), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody RouteEntity oNewRouteEntity) {
        return new ResponseEntity<Long>(oRouteService.create(oNewRouteEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oRouteService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/generate/{amount}")
    public ResponseEntity<Long> generateSome(@PathVariable Long amount) {
        return new ResponseEntity<>(oRouteService.generateSome(amount), HttpStatus.OK);
    }

    
}
