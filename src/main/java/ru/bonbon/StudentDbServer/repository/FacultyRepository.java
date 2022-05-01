package ru.bonbon.StudentDbServer.repository;//package ru.bonbon.StudentDbServer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bonbon.StudentDbServer.entity.Faculty;
import ru.bonbon.StudentDbServer.mappers.FacultyMapper;

import java.util.List;


@Component
public class FacultyRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createFaculty(Faculty faculty){
        return jdbcTemplate.update("insert into \"Faculty\" (\"name\") values (?)", faculty.getName());
    }

    public int deleteFaculty(int id){
        return jdbcTemplate.update("delete from \"Faculty\" where \"id\"=?", id);
    }

    public Faculty getFaculty(int id){
        return jdbcTemplate.queryForObject("select * from \"Faculty\" where \"id\"=?", new FacultyMapper(), id);
    }

    public List<Faculty> getFaculties(){
        return jdbcTemplate.query("select * from \"Faculty\"", new FacultyMapper());
    }

    public int updateFaculty(Faculty faculty){
        return jdbcTemplate.update("update \"Faculty\" set \"name\"=? where \"id\"=?", faculty.getName(),
                faculty.getId());
    }
}

