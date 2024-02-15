package com.middlewaredev.certification_nlw.modules.students.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifiations")
public class CertificationStudentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    
    @Column(nullable = false)
    private String technology;
    
    @Column
    private int grade;
    
    @Column(name = "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(
        name = "student_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private StudentEntity studentEntity;

    //private List<AnswersCertificationsEntity> answersCertificationsEntities;
}
