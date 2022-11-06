package com.example.homework32.controller;

import com.example.homework32.model.Faculty;
import com.example.homework32.model.Student;
import com.example.homework32.service.FacultyService;
;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    public Faculty create(@RequestParam Faculty faculty){
        return facultyService.create(faculty);
    }

    @GetMapping("/{id}")
    public Faculty read(@PathVariable long id){
        return facultyService.read(id);
    }

    @PutMapping("/{id}")
    public Faculty update(@PathVariable long id,
                          @RequestBody Faculty faculty){
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}")
    public Faculty delete(@PathVariable long id){
        return facultyService.delete(id);
    }

    @GetMapping("/{id}")
    public Collection<Faculty> findByColor(@RequestParam String color){
        return facultyService.findByColor(color);
    }

}
