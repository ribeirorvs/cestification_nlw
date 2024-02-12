package com.middlewaredev.certification_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.middlewaredev.certification_nlw.modules.students.DTO.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {
    
    public boolean execute(VerifyHasCertificationDTO dto) {

        if(dto.getEmail().equals("1") && dto.getTechnology().equals("2")){
            return true;
        }
        return false;
    }

}
