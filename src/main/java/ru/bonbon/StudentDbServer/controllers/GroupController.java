package ru.bonbon.StudentDbServer.controllers;

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

    @GetMapping("/get")
    public Group getGroup(@RequestParam("id") int id){
        return repository.getGroup(id);
    }

    @GetMapping("/get-by")
    public List<Group> getGroups(@RequestParam("id_faculty") int idFaculty){
        return repository.getGroupsByFaculty(idFaculty);
    }

    @GetMapping("/get-all")
    public List<Group> getGroups(){
        return repository.getGroups();
    }

    @DeleteMapping("/delete")
    public int deleteGroup(@RequestParam("id") int id){
        return repository.deleteGroup(id);
    }

    @PostMapping("/create")
    public Group createGroup(@RequestBody Group group){
        repository.createGroup(group);
        return group;
    }

    @PutMapping("/update")
    public int updateGroup(@RequestBody Group group){
        return repository.updateGroup(group);
    }
}
