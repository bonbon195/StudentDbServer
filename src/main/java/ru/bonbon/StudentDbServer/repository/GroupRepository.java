package ru.bonbon.StudentDbServer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bonbon.StudentDbServer.entity.Group;
import ru.bonbon.StudentDbServer.mappers.GroupMapper;

import java.util.List;

@Component
public class GroupRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createGroup(Group group){
        return jdbcTemplate.update("insert into \"Group\" (\"id\", \"name\") values (?, ?)", group.getIdFaculty(),
                group.getName());
    }

    public int deleteGroup(int id){
        return jdbcTemplate.update("delete from \"Group\" where \"id\"=?", id);
    }

    public Group getGroup(int id){
        return jdbcTemplate.queryForObject("select * from \"Group\" where \"id\"=?", new GroupMapper(), id);
    }

    public List<Group> getGroupsByFaculty(int idFaculty){
        return jdbcTemplate.query("select * from \"Group\" where \"id_faculty\"=?", new GroupMapper(), idFaculty);
    }

    public List<Group> getGroups(){
        return jdbcTemplate.query("select * from \"Group\"", new GroupMapper());
    }

    public int updateGroup(Group group){
        return jdbcTemplate.update("update \"Group\" set \"name\"=?, \"id_faculty\"=? where \"id\"=?",
                group.getName(), group.getIdFaculty(), group.getId());
    }
}

