package com.middlewaredev.certification_nlw.modules.questions.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.middlewaredev.certification_nlw.modules.questions.entities.QuestionEntity;
import com.middlewaredev.certification_nlw.modules.questions.repositories.QuestionRepository;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")    
    public List<QuestionEntity> findByTechnology (@PathVariable String technology){
        System.out.println(technology);
        return this.questionRepository.findByTechnology(technology);
    }
    

}
