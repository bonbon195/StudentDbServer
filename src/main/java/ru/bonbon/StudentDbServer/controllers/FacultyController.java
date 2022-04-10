package ru.bonbon.StudentDbServer.controllers;

import org.json.JSONException;
import org.json.JSONObject;
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

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Faculty getFaculty(@RequestParam("id") int id){
        return repository.getFaculty(id);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Faculty> getFaculties(){
        return repository.getFaculties();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int deleteFaculty(@RequestParam("id") int id){
        return repository.deleteFaculty(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "text/plain")
    public int createFaculty(@RequestBody String param){
        Faculty faculty = new Faculty();
        try {
            JSONObject jsObject = new JSONObject(param);
            faculty.setName(jsObject.getString("name"));
        }catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.createFaculty(faculty);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "text/plain")
    public int updateFaculty(@RequestBody String param){
        Faculty faculty = new Faculty();
        try {
            JSONObject jsObject = new JSONObject(param);
            faculty.setName(jsObject.getString("name"));
            faculty.setId(jsObject.getInt("id"));
        }catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.updateFaculty(faculty);
    }
}
