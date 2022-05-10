package ru.bonbon.StudentDbServer.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.bonbon.StudentDbServer.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setSurname(rs.getString("surname"));
        student.setPatronymic(rs.getString("patronymic"));
        student.setBirthDate(rs.getString("birthDate"));
        student.setIdGroup(rs.getInt("idGroup"));
        return student;
    }
}
