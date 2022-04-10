package ru.bonbon.StudentDbServer.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.bonbon.StudentDbServer.entity.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMapper implements RowMapper<Faculty> {
    @Override
    public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setId(rs.getInt("id"));
        faculty.setName(rs.getString("name"));
        return faculty;
    }
}
