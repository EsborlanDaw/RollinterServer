package net.ausiasmarch.rollinter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.rollinter.entity.UserEntity;
import net.ausiasmarch.rollinter.repository.UserRepository;
import net.ausiasmarch.rollinter.repository.UsertypeRepository;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.ValidationHelper;


@Service
public class UserService {

    @Autowired
    UsertypeService oUsertypeService;

    private final UsertypeRepository oUsertypeRepository;
    private final UserRepository oUserRepository;

    @Autowired
    public UserService(UserRepository oUserRepository, UsertypeRepository oUsertypeRepository){
        this.oUserRepository = oUserRepository;
        this.oUsertypeRepository = oUsertypeRepository;
    }

    public UserEntity get (Long id) {
        return oUserRepository.findById(id).get();
        //.orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
    }

    public Page<UserEntity> getPage(Pageable oPageable, String strFilter, Long id_team, Long id_usertype) {
        //oAuthService.OnlyAdmins();
        ValidationHelper.validateRPP(oPageable.getPageSize());
        if (strFilter == null || strFilter.length()==0) {
            if (id_team == null) {
                if (id_usertype == null) {
                    return oUserRepository.findAll(oPageable);
                } else {
                    return oUserRepository.findByUsertypeId(id_usertype, oPageable);
                }
            } else {
                if (id_usertype == null) {
                    return oUserRepository.findByTeamId(id_team, oPageable);
                } else {
                    return oUserRepository.findByTeamIdAndUsertypeId(id_team, id_usertype, oPageable);
                }
            }
        } else {
            if (id_team == null) {
                if (id_usertype == null) {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContaining(strFilter, strFilter, strFilter, oPageable);
                } else {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndUsertypeId(strFilter, strFilter, strFilter, id_usertype, oPageable);
                }
            } else {
                if (id_usertype == null) {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndTeamId(strFilter, strFilter, strFilter, id_team, oPageable);
                } else {
                    return oUserRepository.findByNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContainingAndTeamIdAndUsertypeId(strFilter, strFilter, strFilter, id_team, id_usertype, oPageable);
                }
            }
        }

    }
}
