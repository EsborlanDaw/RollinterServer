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

import net.ausiasmarch.rollinter.entity.TeamEntity;
import net.ausiasmarch.rollinter.service.TeamService;

import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService oTeamService;

    @GetMapping("/{id}")
    public ResponseEntity<TeamEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<TeamEntity>(oTeamService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable(value = "id") Long id) {
        return oTeamService.delete(id);
    }

    @GetMapping("")
    public ResponseEntity<Page<TeamEntity>> getPage(
            @ParameterObject @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable oPageable,
            @RequestParam(name = "filter", required = false) String strFilter,
            @RequestParam(name = "developer", required = false) Long lDeveloper) {
        return new ResponseEntity<Page<TeamEntity>>(oTeamService.getPage(oPageable, strFilter, lDeveloper), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody TeamEntity oTeamEntity) {
        return new ResponseEntity<Long>(oTeamService.create(oTeamEntity), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oTeamService.count(), HttpStatus.OK);
    }

    
    @PutMapping("/")
    public ResponseEntity<Long> update(@RequestBody TeamEntity oTeamEntity) {
        return new ResponseEntity<Long>(oTeamService.update(oTeamEntity), HttpStatus.OK);
    }

    @PostMapping("/generate")
    public ResponseEntity<TeamEntity> generateOne() {
        return new ResponseEntity<>(oTeamService.generateOne(), HttpStatus.OK);
    }

    @PostMapping("/generate/{amount}")
    public ResponseEntity<Long> generateSome(@PathVariable Long amount) {
        return new ResponseEntity<>(oTeamService.generateSome(amount), HttpStatus.OK);
    }
    
}

