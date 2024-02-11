package com.middlewaredev.certification_nlw.modules.students.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswersCertificationsEntity {
    
    private UUID id;
    private UUID studentId;
    private UUID questionId;
    private UUID certificationId;
    private UUID answerId;
    private boolean isCorrect;
}
