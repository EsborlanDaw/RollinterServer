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

import org.springframework.data.domain.Sort;

import net.ausiasmarch.rollinter.entity.CoordinatesEntity;
import net.ausiasmarch.rollinter.service.CoordinatesService;

@RestController
@RequestMapping("/coordinates")
public class CoordinatesController {

    @Autowired
    private CoordinatesService oCoordinatesService;

    @GetMapping("/{id}")
    public ResponseEntity<CoordinatesEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<CoordinatesEntity>(oCoordinatesService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oCoordinatesService.count(), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody CoordinatesEntity oCoordinatesEntity) {
        return new ResponseEntity<Long>(oCoordinatesService.update(oCoordinatesEntity), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody CoordinatesEntity oNewCoordinatesEntity) {
        return new ResponseEntity<Long>(oCoordinatesService.create(oNewCoordinatesEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oCoordinatesService.delete(id), HttpStatus.OK);
    }

    
}
