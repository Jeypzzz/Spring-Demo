package com.dearwolves.demo.service.impl;

import com.dearwolves.demo.model.entity.Student;
import com.dearwolves.demo.repository.StudentRepository;
import com.dearwolves.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        if(studentRepository.existsById(student.getId()))
            return null;

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        try {
            Optional<Student> student = studentRepository.findById(Long.parseLong(id));
            return student.orElse(null);
        } catch (NumberFormatException e) {
            return  null;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        if(!studentRepository.existsById(student.getId()))
            return null;

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
