package net.ausiasmarch.rollinter.service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import net.ausiasmarch.rollinter.bean.UserBean;
import net.ausiasmarch.rollinter.exception.UnauthorizedException;
import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.helper.RandomHelper;
import net.ausiasmarch.rollinter.helper.UsertypeHelper;
import net.ausiasmarch.rollinter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    HttpSession oHttpSession;

    @Autowired
    UserRepository oUserRepository;

    /*@Autowired
    QuestionRepository oQuestionRepository;

    @Autowired
    PendentRepository oPendentRepository;*/

    public UserEntity login(@RequestBody UserBean oUserBean) {
        if (oUserBean.getPassword() != null) {
            UserEntity oUserEntity = oUserRepository.findByUsernameAndPassword(oUserBean.getUsername(), oUserBean.getPassword());
            if (oUserEntity != null) {
                oHttpSession.setAttribute("User", oUserEntity);
                return oUserEntity;
            } else {
                throw new UnauthorizedException("login or password incorrect");
            }
        } else {
            throw new UnauthorizedException("wrong password");
        }
    }

    public void logout() {
        oHttpSession.invalidate();
    }

    public UserEntity check() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity != null) {
            return oUserSessionEntity;
        } else {
            throw new UnauthorizedException("no active session");
        }
    }

    public boolean isLoggedIn() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity == null) {
            return false;
        } else {
            return true;
        }
    }

    public Long getUserID() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity != null) {
            return oUserSessionEntity.getId();
        } else {
            throw new UnauthorizedException("this request is only allowed to auth users");
        }
    }

    public boolean isAdmin() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity != null) {
            if (oUserSessionEntity.getUsertype().getId().equals(UsertypeHelper.ADMIN)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUser() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity != null) {
            if (oUserSessionEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                return true;
            }
        }
        return false;
    }

    public void OnlyAdmins() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity == null) {
            throw new UnauthorizedException("this request is only allowed to admin role");
        } else {
            if (!oUserSessionEntity.getUsertype().getId().equals(UsertypeHelper.ADMIN)) {
                throw new UnauthorizedException("this request is only allowed to admin role");
            }
        }
    }

    public void OnlyUsers() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity == null) {
            throw new UnauthorizedException("this request is only allowed to user role");
        } else {
            if (!oUserSessionEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                throw new UnauthorizedException("this request is only allowed to user role");
            }
        }
    }

    public void OnlyAdminsOrUsers() {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity == null) {
            throw new UnauthorizedException("this request is only allowed to user or admin role");
        } else {

        }
    }

    public void OnlyAdminsOrOwnUsersData(Long id) {
        UserEntity oUserSessionEntity = (UserEntity) oHttpSession.getAttribute("User");
        if (oUserSessionEntity != null) {
            if (oUserSessionEntity.getUsertype().getId().equals(UsertypeHelper.ROLLUSER)) {
                if (!oUserSessionEntity.getId().equals(id)) {
                    throw new UnauthorizedException("this request is only allowed for your own data");
                }
            }
        } else {
            throw new UnauthorizedException("this request is only allowed to user or admin role");
        }
    }

    /*@Transactional
    public CaptchaResponse prelogin() {

        Long iRandom = Long.valueOf(RandomHelper.getRandomInt(1, (int) oQuestionRepository.count())); //pte cambiar el 5 

        QuestionEntity oQuestionEntity = oQuestionRepository.findById(iRandom).get();

        PendentEntity oPendentEntity = new PendentEntity();
        oPendentEntity.setQuestion(oQuestionEntity);
        PendentEntity oPendentEntityNueva = oPendentRepository.save(oPendentEntity);
        oPendentEntityNueva.setToken(RandomHelper.getSHA256("" + iRandom + oPendentEntityNueva.getId() + RandomHelper.getRandomInt(1, 9999)));
        oPendentRepository.save(oPendentEntityNueva);

        CaptchaResponse oCaptchaResponse = new CaptchaResponse();
        oCaptchaResponse.setQuestion(oPendentEntityNueva.getQuestion().getStatement());
        oCaptchaResponse.setToken(oPendentEntityNueva.getToken());

        return oCaptchaResponse;
    }

    public UserEntity loginc(CaptchaBean oCaptchaBean) {
        if (oCaptchaBean.getPassword() != null) {
            UserEntity oUserEntity = oUserRepository.findByLoginAndPassword(oCaptchaBean.getLogin(), oCaptchaBean.getPassword());
            if (oUserEntity != null) {
                // valida login y pass
                PendentEntity oPendentEntity = oPendentRepository.findByToken(oCaptchaBean.getToken());
                if (oPendentEntity.getQuestion().getResponse().toLowerCase().contains(oCaptchaBean.getAnswer().toLowerCase())) {
                    oHttpSession.setAttribute("User", oUserEntity);
                    //borrar el reg
                    oPendentRepository.delete(oPendentEntity);                                        
                    return oUserEntity;
                } else {
                    throw new UnauthorizedException("wrong login or password or response");
                }
            } else {
                throw new UnauthorizedException("login or password incorrect");
            }
        } else {
            throw new UnauthorizedException("wrong password");
        }
    }*/

}