package com.dearwolves.demo.web.controller.rest;

import com.dearwolves.demo.model.dto.StudentDTO;
import com.dearwolves.demo.model.entity.Student;
import com.dearwolves.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody StudentDTO params){
        Student student = new Student(params.getFirstName(), params.getLastName());

        return ResponseEntity
                .ok(studentService.createStudent(student));
    }

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    public ResponseEntity<?> getStudents(){
        return ResponseEntity
                .ok(studentService.getStudents());
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> getStudentById(@PathVariable String id){
        Student student = studentService.getStudentById(id);

        if(student == null)
            return ResponseEntity.ok("No record found");

        return ResponseEntity
                .ok(student);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody StudentDTO params){
        Student student = new Student(params.getId(), params.getFirstName(), params.getLastName());

        if(studentService.updateStudent(student) == null)
            return ResponseEntity.ok("No record found");

        return ResponseEntity
                .ok(student);
    }
}
