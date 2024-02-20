package com.middlewaredev.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.middlewaredev.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.middlewaredev.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.middlewaredev.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.middlewaredev.certification_nlw.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.middlewaredev.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;


@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private VerifyIfHasCertificationUseCase VerifyIfHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

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
 
    
    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) throws Exception {
        try{
            var result = this.studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
