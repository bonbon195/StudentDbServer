package ru.bonbon.StudentDbServer.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.bonbon.StudentDbServer.entity.Group;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setName(rs.getString("name"));
        group.setIdFaculty(rs.getInt("idFaculty"));
        return group;
    }
}
