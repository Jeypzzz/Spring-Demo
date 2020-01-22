package com.dearwolves.demo.web;

import com.dearwolves.demo.domain.Student;
import com.dearwolves.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestBody Student student){
        studentRepository.save(new Student(student.getFirstName(), student.getLastName()));
        return "Customer is created";
    }

}
