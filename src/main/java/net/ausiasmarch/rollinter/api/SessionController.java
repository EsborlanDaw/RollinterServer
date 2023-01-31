package net.ausiasmarch.rollinter.api;

import net.ausiasmarch.rollinter.bean.UserBean;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    AuthService oAuthService;

    @PostMapping
    public ResponseEntity<String> login(@org.springframework.web.bind.annotation.RequestBody UserBean oUserBean) {
        return new ResponseEntity<String>("\"" + oAuthService.login(oUserBean) + "\"", HttpStatus.OK);
    }

   

//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<UserEntity> login(
//            @org.springframework.web.bind.annotation.RequestBody // Spring
//            @io.swagger.v3.oas.annotations.parameters.RequestBody // Swagger
//            @Valid // Bean validation to ensure if the incoming object is valid
//            final UserBean oUserBean ) //            @RequestBody(description = "login endpoint", required = true, content = @Content(schema = @Schema(implementation = UserEntity.class))) UserBean oUserBean) ,
//    {
//        return new ResponseEntity<UserEntity>(oAuthService.login(oUserBean), HttpStatus.OK);
//    }
  

}


