package com.middlewaredev.certification_nlw.modules.students.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerDTO {
    
    private UUID questionId;
    private UUID alternativeId;
    private boolean isCorrect;
}
