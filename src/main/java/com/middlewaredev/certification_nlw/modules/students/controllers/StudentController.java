package com.middlewaredev.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.middlewaredev.certification_nlw.modules.students.DTO.VerifyHasCertificationDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.middlewaredev.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;


@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private VerifyIfHasCertificationUseCase VerifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String postMethodName(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
        // Email
        // Technology
        
        var result = this.VerifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);

        if(result){
            return "User has a certification of it";
        }

        System.out.println(verifyHasCertificationDTO);
        return "User can do the test.";
    }
    
}
