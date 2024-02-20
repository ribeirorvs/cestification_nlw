package com.middlewaredev.certification_nlw.modules.students.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middlewaredev.certification_nlw.modules.questions.entities.QuestionEntity;
import com.middlewaredev.certification_nlw.modules.questions.repositories.QuestionRepository;
import com.middlewaredev.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.middlewaredev.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.middlewaredev.certification_nlw.modules.students.entities.AnswersCertificationsEntity;
import com.middlewaredev.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.middlewaredev.certification_nlw.modules.students.entities.StudentEntity;
import com.middlewaredev.certification_nlw.modules.students.repositories.CertificationStudentRepository;
import com.middlewaredev.certification_nlw.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
    
    private List<AnswersCertificationsEntity> answersCertificationsEntities = new ArrayList<>();
    private int correctAnswers = 0;
    
    public CertificationStudentEntity execute(StudentCertificationAnswerDTO dto) throws Exception {

        var hasCertification = this.verifyIfHasCertificationUseCase.execute(new VerifyHasCertificationDTO(dto.getEmail(), dto.getTechnology()));

        if(hasCertification){
            throw new Exception("You have this certification!");
        }
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
                    correctAnswers++;
                } else {
                    questionAnswer.setCorrect(false);
                }

                var newAnswersCertificationsEntity = AnswersCertificationsEntity.builder()
                    .answerId(questionAnswer.getAlternativeId())
                    .questionId(questionAnswer.getQuestionId())
                    .isCorrect(questionAnswer.isCorrect())
                    .build();

                answersCertificationsEntities.add(newAnswersCertificationsEntity);
            });

        
        var student = studentRepository.findByEmail(dto.getEmail());
        UUID studentID;
        if(student.isEmpty()){
            var newStudent = StudentEntity.builder().email(dto.getEmail()).build();
            newStudent = studentRepository.save(newStudent);
            studentID = newStudent.getId();
        } else {
            studentID = student.get().getId();
        }


        CertificationStudentEntity certificationStudentEntity = 
            CertificationStudentEntity.builder()
                .technology(dto.getTechnology())
                .studentID(studentID)
                .grade(correctAnswers)
                .build();

                
                answersCertificationsEntities.stream().forEach(answersCertification -> {
                    answersCertification.setCertificationId(certificationStudentEntity.getId());
                    answersCertification.setCertificationStudentEntity(certificationStudentEntity);
                });
                
        certificationStudentEntity.setAnswersCertificationsEntities(answersCertificationsEntities);
                
        var newCertificationStudent = certificationStudentRepository.save(certificationStudentEntity);

        return newCertificationStudent;
    }

}