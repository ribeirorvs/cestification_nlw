package com.middlewaredev.certification_nlw.modules.students.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCertificationAnswerDTO {
    
    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionsAnswers;

}
