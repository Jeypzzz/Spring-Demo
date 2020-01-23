package com.dearwolves.demo.service;

import com.dearwolves.demo.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getStudents();

    Student getStudentById(String id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

}
