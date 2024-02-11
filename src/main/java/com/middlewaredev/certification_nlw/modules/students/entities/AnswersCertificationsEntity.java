package com.middlewaredev.certification_nlw.modules.students.entities;

import java.util.UUID;

public class AnswersCertificationsEntity {
    
    private UUID id;
    private UUID studentId;
    private UUID questionId;
    private UUID certificationId;
    private UUID answerId;
    private boolean isCorrect;
}
