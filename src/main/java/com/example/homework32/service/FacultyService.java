package com.example.homework32.service;

import com.example.homework32.exception.FacultyNotFoundException;
import com.example.homework32.exception.StudentNotFoundException;
import com.example.homework32.model.Faculty;
import com.example.homework32.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private long idGenerator = 1;

    public Faculty create(Faculty faculty){
        faculty.setId(idGenerator++);
        facultyMap.put(faculty.getId(),faculty);
        return faculty;
    }

    public Faculty read(long id){
        if (!facultyMap.containsKey(id)){
            throw new FacultyNotFoundException(id);
        }
        return facultyMap.get(id);
    }

    public Faculty update(long id,
                          Faculty newFaculty){
        Faculty oldFaculty = read(id);
        oldFaculty.setColor(newFaculty.getName());
        oldFaculty.setName(newFaculty.getColor());
        facultyMap.put(id, oldFaculty);
        return newFaculty;
    }

    public Faculty delete(long id){
        if (!facultyMap.containsKey(id)){
            throw new FacultyNotFoundException(id);
        }
        return facultyMap.remove(id);
    }

    public Collection<Faculty> findByColor(String color){
        return facultyMap.values().stream()
                .filter(student -> student.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
