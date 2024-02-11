package com.middlewaredev.certification_nlw.modules.students.entities;

import java.util.List;
import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CestificationStudentEntity {
    
    private UUID id;
    private UUID studentId;
    private String technology;
    private int grade;
    private List<AnswersCertificationsEntity> answersCertificationsEntities;
}
