package com.middlewaredev.certification_nlw.modules.students.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middlewaredev.certification_nlw.modules.questions.entities.QuestionEntity;
import com.middlewaredev.certification_nlw.modules.questions.repositories.QuestionRepository;
import com.middlewaredev.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private QuestionRepository questionRepository;
    
    public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO dto) {

        List<QuestionEntity> questionEntities = questionRepository.findByTechnology(dto.getTechnology());

        dto.getQuestionsAnswers().stream()
            .forEach(questionAnswer -> {
                System.out.println(questionAnswer);
                var questionEntity = questionEntities.stream()
                                        .filter(question -> question.getId().equals(questionAnswer.getQuestionId()))
                                        .findFirst().get();
                System.out.println(questionEntity);


                var findCorrectAlternative = questionEntity.getAlternatives().stream().filter(alternative -> alternative.isCorrect())
                                        .findFirst().get();

                if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeId())){
                    questionAnswer.setCorrect(true);
                } else {
                    questionAnswer.setCorrect(false);
                }
            });

        return dto;
    }

}