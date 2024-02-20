package com.middlewaredev.certification_nlw.modules.students.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.middlewaredev.certification_nlw.modules.students.entities.CertificationStudentEntity;

public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID>{
    
    @Query("Select c from certifications c inner join c.studentEntity std where std.email = :email and c.technology = :technology")
    List<CertificationStudentEntity> findByStudentEmailAndTechnology(String email, String technology);

    @Query("Select c from certifications c order by c.grade desc limit 10")
    List<CertificationStudentEntity> findTop10ByOrderByGradeDesc();
}
