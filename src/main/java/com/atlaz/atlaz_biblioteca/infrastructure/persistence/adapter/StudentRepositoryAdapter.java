package com.atlaz.atlaz_biblioteca.infrastructure.persistence.adapter;

import com.atlaz.atlaz_biblioteca.application.port.out.StudentRepository;
import com.atlaz.atlaz_biblioteca.domain.model.Student;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.StudentEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentRepositoryAdapter implements StudentRepository {

    private final StudentJpaRepository jpaRepository;

    public StudentRepositoryAdapter(StudentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Student save(Student student) {
        StudentEntity entity = new StudentEntity();
        entity.setRegistration(student.getRegistration());
        entity.setName(student.getName());
        entity.setEmail(student.getEmail());
        entity.setImageId(student.getImageId());

        StudentEntity saved = jpaRepository.save(entity);

        student.setId(saved.getId());
        return student;
    }
}

// realizará a conexão do CreateStudentUseCase com a porta StudentRepository utilizando JPA.