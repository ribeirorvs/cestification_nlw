package com.middlewaredev.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.middlewaredev.certification_nlw.modules.students.DTO.VerifyHasCertificationDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/students")
public class StudentController {
    
    @PostMapping("/verifyIfHasCertification")
    public String postMethodName(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
        // Email
        // Technology
        
        System.out.println(verifyHasCertificationDTO);
        return "User can do the test.";
    }
    
}
