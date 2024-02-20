package com.middlewaredev.certification_nlw.modules.certifications.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.middlewaredev.certification_nlw.modules.certifications.useCases.Top10RankingUseCase;
import com.middlewaredev.certification_nlw.modules.students.entities.CertificationStudentEntity;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/ranking")
public class RankingController {
    
    @Autowired
    private Top10RankingUseCase top10RankingUseCase;

    @GetMapping("/top10")
    public List<CertificationStudentEntity> top10() {
        return this.top10RankingUseCase.execute();
    }
    

}
