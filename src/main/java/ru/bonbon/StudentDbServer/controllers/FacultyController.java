package ru.bonbon.StudentDbServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bonbon.StudentDbServer.entity.Faculty;
import ru.bonbon.StudentDbServer.repository.FacultyRepository;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    @Autowired
    FacultyRepository repository;

    @GetMapping("/get")
    public Faculty getFaculty(@RequestParam("id") int id){
        return repository.getFaculty(id);
    }

    @GetMapping("/get-all")
    public List<Faculty> getFaculties(){
        return repository.getFaculties();
    }

    @DeleteMapping("/delete")
    public int deleteFaculty(@RequestParam("id") int id){
        return repository.deleteFaculty(id);
    }

    @PostMapping("/create")
    public Faculty createFaculty(@RequestBody Faculty faculty){
        repository.createFaculty(faculty);
        return faculty;
    }

    @PutMapping("/update")
    public int updateFaculty(@RequestBody Faculty faculty){
        return repository.updateFaculty(faculty);
    }
}
