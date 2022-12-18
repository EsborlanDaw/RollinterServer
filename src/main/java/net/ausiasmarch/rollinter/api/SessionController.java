package net.ausiasmarch.rollinter.api;

import javax.servlet.http.HttpSession;
import net.ausiasmarch.rollinter.bean.UserBean;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.service.AuthService;
import net.ausiasmarch.rollinter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    HttpSession oHttpSession;

    @GetMapping("")
    public ResponseEntity<UserBean> check() {
        UserBean oUserBean = (UserBean) oHttpSession.getAttribute("User");
        if (oUserBean == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<UserBean>(oUserBean, HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<UserBean> login(@RequestBody UserBean oUserBean) {
        if (oUserBean.getUsername().equalsIgnoreCase("admin")
               && oUserBean.getPassword().equalsIgnoreCase("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")) {
            oHttpSession.setAttribute("User", oUserBean);
            return new ResponseEntity<UserBean>(oUserBean, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> logout() {
        oHttpSession.invalidate();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}


