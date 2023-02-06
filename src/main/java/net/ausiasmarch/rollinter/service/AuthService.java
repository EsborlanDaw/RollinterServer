package net.ausiasmarch.rollinter.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import net.ausiasmarch.rollinter.bean.UserBean;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.exception.UnauthorizedException;
import net.ausiasmarch.rollinter.helper.JwtHelper;
import net.ausiasmarch.rollinter.helper.UsertypeHelper;
import net.ausiasmarch.rollinter.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private HttpServletRequest oRequest;

    @Autowired
    UserRepository oUserRepository;

    public String login(@RequestBody UserBean oUserBean) {
        if (oUserBean.getPassword() != null) {
            UserEntity oUserEntity = oUserRepository.findByUsernameAndPassword(oUserBean.getUsername(), oUserBean.getPassword());
            if (oUserEntity != null) {
                return JwtHelper.generateJWT(oUserBean.getUsername(), oUserEntity.getUsertype().getId());
            } else {
                throw new UnauthorizedException("username or password incorrect");
            }
        } else {
            throw new UnauthorizedException("password can not be empty");
        }
    }

    public boolean isAdmin() {
        UserEntity oUserSessionEntity = oUserRepository.findByUsername((String) oRequest.getAttribute("user"));
        if (oUserSessionEntity != null) {
            if (oUserSessionEntity.getUsertype().getId().equals(UsertypeHelper.ADMIN)) {
                return true;
            }
        }
        return false;
    }

    public void OnlyAdmins() {
        UserEntity oUserSessionEntity = oUserRepository.findByUsername((String) oRequest.getAttribute("user"));
        if (oUserSessionEntity == null) {
            throw new UnauthorizedException("this request is only allowed to admin role");
        } else {
            if (!oUserSessionEntity.getUsertype().getId().equals(UsertypeHelper.ADMIN)) {
                throw new UnauthorizedException("this request is only allowed to admin role");
            }
        }
    }

    public boolean isLoggedIn() {
        String strUser = (String) oRequest.getAttribute("user");
        if (strUser == null) {
            return false;
        } else {
            return true;
        }
    }

    public Long getUserID() {
        String strUser = (String) oRequest.getAttribute("user");
        UserEntity oUserEntity = oUserRepository.findByUsername(strUser);
        if (oUserEntity != null) {
            return oUserEntity.getId();
        } else {
            throw new UnauthorizedException("this request is only allowed to auth Users");
        }
    }


    public boolean isUser() {
        String strUser = (String) oRequest.getAttribute("user");
        UserEntity oUserEntity = oUserRepository.findByUsername(strUser);
        if (oUserEntity != null) {
            if (oUserEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                return true;
            }
        }
        return false;
    }

    public void OnlyUsers() {
        String strUser = (String) oRequest.getAttribute("user");
        UserEntity oUserEntity = oUserRepository.findByUsername(strUser);
        if (oUserEntity == null) {
            throw new UnauthorizedException("this request is only allowed to User role");
        } else {
            if (!oUserEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                throw new UnauthorizedException("this request is only allowed to User role");
            }
        }
    }

    public void OnlyAdminsOrUsers() {
        String strUser = (String) oRequest.getAttribute("user");
        UserEntity oUserEntity = oUserRepository.findByUsername(strUser);
        if (oUserEntity == null) {
            throw new UnauthorizedException("this request is only allowed to admin or rolluser role");
        } else {
            if (oUserEntity.getUsertype().getId().equals(UsertypeHelper.ADMIN)) {
            } else {
                if (oUserEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                } else {
                    throw new UnauthorizedException("this request is only allowed to admin or rolluser role");
                }
            }
        }
    }

    public void OnlyAdminsOrOwnUsersData(Long id) {
        String strUser = (String) oRequest.getAttribute("user");
        UserEntity oUserEntity = oUserRepository.findByUsername(strUser);
        if (oUserEntity != null) {
            if (oUserEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                if (!oUserEntity.getId().equals(id)) {
                    throw new UnauthorizedException("this request is only allowed for your own data");
                }
            }
        } else {
            throw new UnauthorizedException("this request is only allowed to user or admin role");
        }
    }

    public void OnlyOwnUsersData(Long id) {
        String strUser = (String) oRequest.getAttribute("user");
        UserEntity oUserEntity = oUserRepository.findByUsername(strUser);
        if (oUserEntity != null) {
            if (oUserEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                if (!oUserEntity.getId().equals(id)) {
                    throw new UnauthorizedException("this request is only allowed for your own User data");
                }
            } else {
                throw new UnauthorizedException("this request is only allowed to User role");
            }
        } else {
            throw new UnauthorizedException("this request is only allowed to User role");
        }
    }

}