package ru.bonbon.StudentDbServer.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bonbon.StudentDbServer.entity.Student;
import ru.bonbon.StudentDbServer.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentRepository repository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Student getStudent(@RequestParam("id") int id){
        return repository.getStudent(id);
    }

    @RequestMapping(value = "/get-by", method = RequestMethod.GET)
    public List<Student> getStudentsByGroup(@RequestParam("id_group") int idGroup){
        return repository.getStudentsByGroup(idGroup);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Student> getStudents(){
        return repository.getStudents();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int deleteStudent(@RequestParam("id") int id){
        return repository.deleteStudent(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int createStudent(@RequestBody String param){
        Student student = new Student();
        try {
            JSONObject jsObject = new JSONObject(param);
            student.setName(jsObject.getString("name"));
            student.setSurname(jsObject.getString("surname"));
            student.setPatronymic(jsObject.getString("patronymic"));
            student.setBirthDate(jsObject.getString("birth_date"));
            student.setIdGroup(jsObject.getInt("id_group"));
        }catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.createStudent(student);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updateGroup(@RequestBody String param){
        Student student = new Student();
        try {
            JSONObject jsObject = new JSONObject(param);
            student.setId(jsObject.getInt("id"));
            student.setName(jsObject.getString("name"));
            student.setSurname(jsObject.getString("surname"));
            student.setPatronymic(jsObject.getString("patronymic"));
            student.setBirthDate(jsObject.getString("birth_date"));
            student.setIdGroup(jsObject.getInt("id_group"));
        }catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.updateStudent(student);
    }
}
