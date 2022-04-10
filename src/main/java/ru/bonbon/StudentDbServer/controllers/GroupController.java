package ru.bonbon.StudentDbServer.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bonbon.StudentDbServer.entity.Group;
import ru.bonbon.StudentDbServer.repository.GroupRepository;

import java.util.List;

@RestController
@RequestMapping("group")
public class GroupController {
    @Autowired
    GroupRepository repository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Group getGroup(@RequestParam("id") int id){
        return repository.getGroup(id);
    }

    @RequestMapping(value = "/get-by", method = RequestMethod.GET)
    public List<Group> getGroupsByFaculty(@RequestParam("id_faculty") int idFaculty){
        return repository.getGroupsByFaculty(idFaculty);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Group> getGroups(){
        return repository.getGroups();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int deleteGroup(@RequestParam("id") int id){
        return repository.deleteGroup(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "text/plain")
    public int createGroup(@RequestBody String param){
        Group group = new Group();
        try {
            JSONObject jsObject = new JSONObject(param);
            group.setName(jsObject.getString("name"));
            group.setIdFaculty(jsObject.getInt("id_faculty"));
        }catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.createGroup(group);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "text/plain")
    public int updateGroup(@RequestBody String param){
        Group group = new Group();
        try {
            JSONObject jsObject = new JSONObject(param);
            group.setName(jsObject.getString("name"));
            group.setId(jsObject.getInt("id"));
            group.setIdFaculty(jsObject.getInt("id_faculty"));
        }catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.updateGroup(group);
    }
}
