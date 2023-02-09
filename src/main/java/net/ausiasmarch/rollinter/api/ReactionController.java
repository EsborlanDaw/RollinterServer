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

import net.ausiasmarch.rollinter.entity.ReactionEntity;
import net.ausiasmarch.rollinter.service.ReactionService;

import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/reaction")

public class ReactionController {

    @Autowired
    private ReactionService oReactionService;

    @GetMapping("/")
    public ResponseEntity<Page<ReactionEntity>> getPage(
            @ParameterObject @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable oPageable,
            @RequestParam(name = "filter", required = false) Long strFilter,
            @RequestParam(value = "user", required = false) Long id_user,
            @RequestParam(value = "route", required = false) Long id_route) {
        return new ResponseEntity<>(oReactionService.getPage(oPageable, strFilter, id_user, id_route), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Long> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oReactionService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oReactionService.count(), HttpStatus.OK);
    }

    /* @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody ReactionEntity oReactionEntity) {
        return new ResponseEntity<Long>(oReactionService.update(oReactionEntity), HttpStatus.OK);
    } */

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody ReactionEntity oNewReactionEntity) {
        return new ResponseEntity<Long>(oReactionService.create(oNewReactionEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oReactionService.delete(id), HttpStatus.OK);
    }
    
}
