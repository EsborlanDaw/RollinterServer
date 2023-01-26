package net.ausiasmarch.rollinter.service;

import net.ausiasmarch.rollinter.entity.UsertypeEntity;
import net.ausiasmarch.rollinter.exception.ResourceNotFoundException;
import net.ausiasmarch.rollinter.exception.ResourceNotModifiedException;
import net.ausiasmarch.rollinter.helper.ValidationHelper;
import net.ausiasmarch.rollinter.repository.UsertypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsertypeService {

    private final UsertypeRepository oUsertypeRepository;
    private final AuthService oAuthService;

    @Autowired
    public UsertypeService(UsertypeRepository oUsertypeRepository, AuthService oAuthService) {
        this.oUsertypeRepository = oUsertypeRepository;
        this.oAuthService = oAuthService;
    }

    public void validate(Long id) {
        if (!oUsertypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    public void validate(UsertypeEntity oUsertypeEntity) {
        ValidationHelper.validateStringLength(oUsertypeEntity.getName(), 2,50, "campo name de User(el campo debe tener longitud de 2 a 50 caracteres)");
        
    }

    public UsertypeEntity get(Long id) {
        //oAuthService.OnlyAdmins();
        return oUsertypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserType with id: " + id + " not found"));
    }

    public Long count() {
        //oAuthService.OnlyAdmins();
        return oUsertypeRepository.count();
    }

    public Page<UsertypeEntity> getPage(int page, int size) {
       //oAuthService.OnlyAdmins();
        Pageable oPageable = PageRequest.of(page, size);
        
            return oUsertypeRepository.findAll(oPageable);
    }

    public Long update(UsertypeEntity oUsertypeEntity) {
       //oAuthService.OnlyAdmins();
        validate(oUsertypeEntity.getId());
        oUsertypeRepository.save(oUsertypeEntity);
        return oUsertypeEntity.getId();
    }

    public Long create(UsertypeEntity oNewUsertypeEntity) {
        //oAuthService.OnlyAdmins();
        validate(oNewUsertypeEntity);
        oNewUsertypeEntity.setId(0L);
        return oUsertypeRepository.save(oNewUsertypeEntity).getId();
    }

    public Long delete(Long id) {
        //oAuthService.OnlyAdmins();
        validate(id);
        oUsertypeRepository.deleteById(id);
        if (oUsertypeRepository.existsById(id)) {
            throw new ResourceNotModifiedException("can't remove register " + id);
        } else {
            return id;
        }
    }
    
}

