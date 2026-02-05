package com.atlaz.atlaz_biblioteca.application.port.out;

import com.atlaz.atlaz_biblioteca.domain.model.Student;

public interface StudentRepository {

    Student save(Student student);

}
