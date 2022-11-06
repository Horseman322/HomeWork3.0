package com.example.homework32.controller;


import com.example.homework32.model.Student;
import com.example.homework32.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
@PostMapping
    public Student create(@RequestParam Student student){
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public Student read(@PathVariable long id){
        return studentService.read(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable long id,
                          @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable long id){
        return studentService.delete(id);
    }

    @GetMapping("/{id}")
    public Collection<Student> findByAge(@RequestParam int age){
        return studentService.findByAge(age);
    }

}
