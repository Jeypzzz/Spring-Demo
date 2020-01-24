package com.dearwolves.demo.web.controller;

import com.dearwolves.demo.model.entity.Student;
import com.dearwolves.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Student student) {
        return "add-student";
    }

    @PostMapping("/add")
    public String home(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        studentService.createStudent(student);
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }
        studentService.updateStudent(student);
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        studentService.deleteStudentById(id);
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }
}
