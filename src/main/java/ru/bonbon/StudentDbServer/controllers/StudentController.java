package ru.bonbon.StudentDbServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bonbon.StudentDbServer.entity.Student;
import ru.bonbon.StudentDbServer.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentRepository repository;

    @GetMapping("/get")
    public Student getStudent(@RequestParam("id") int id){
        return repository.getStudent(id);
    }

    @GetMapping("/get-by")
    public List<Student> getStudents(@RequestParam("id_group") int idGroup){
        return repository.getStudentsByGroup(idGroup);
    }

    @GetMapping("/get-all")
    public List<Student> getStudents(){
        return repository.getStudents();
    }

    @DeleteMapping("/delete")
    public int deleteStudent(@RequestParam("id") int id){
        return repository.deleteStudent(id);
    }

    @PostMapping("/create")
    public int createStudent(@RequestBody Student student){
        return repository.createStudent(student);
    }

    @PutMapping("/update")
    public int updateStudent(@RequestBody Student student){
        return repository.updateStudent(student);
    }
}
