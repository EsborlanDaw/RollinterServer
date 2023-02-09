package net.ausiasmarch.rollinter.api;


import java.util.List;

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

import net.ausiasmarch.rollinter.entity.CommentEntity;
import net.ausiasmarch.rollinter.service.CommentService;

import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    private CommentService oCommentService;

    @GetMapping
    public ResponseEntity<Page<CommentEntity>> getPage(
            @ParameterObject @PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) Pageable oPageable,
            @RequestParam(name = "filter", required = false) String strFilter,
            @RequestParam(value = "route", required = false) Long id_route,
            @RequestParam(value = "user", required = false) Long id_user) {
        return new ResponseEntity<>(oCommentService.getPage(oPageable, strFilter, id_route, id_user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <List<CommentEntity>> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity <List<CommentEntity>>(oCommentService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oCommentService.count(), HttpStatus.OK);
    }

    /* @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody CommentEntity oCommentEntity) {
        return new ResponseEntity<Long>(oCommentService.update(oCommentEntity), HttpStatus.OK);
    } */

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody CommentEntity oNewCommentEntity) {
        return new ResponseEntity<Long>(oCommentService.create(oNewCommentEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{id_user}")
    public ResponseEntity<Long> getValues(@PathVariable (value = "id") Long id, @PathVariable (value = "id_user") Long id_user) {
        return new ResponseEntity<Long>(oCommentService.delete(id, id_user), HttpStatus.OK);
    }

   /*  @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Long>(oCommentService.delete(id), HttpStatus.OK);
    }
     */
}
