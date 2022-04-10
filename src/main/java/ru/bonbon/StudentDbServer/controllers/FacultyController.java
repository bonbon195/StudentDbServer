package ru.bonbon.StudentDbServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bonbon.StudentDbServer.entity.Faculty;
import ru.bonbon.StudentDbServer.repository.FacultyRepository;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private FacultyRepository repository;

    @Autowired
    public FacultyController(FacultyRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Faculty> get(@PathVariable("id") Long id){
        Faculty faculty = repository.getById(id);
        if (faculty == null) {
            return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Faculty>(HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        repository.save(faculty);
        return get(faculty.getId());
    }

    @RequestMapping
    public List<Faculty> getAll(){
        return repository.findAll();
    }

}
