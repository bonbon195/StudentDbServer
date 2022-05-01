package ru.bonbon.StudentDbServer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bonbon.StudentDbServer.entity.Student;
import ru.bonbon.StudentDbServer.mappers.StudentMapper;

import java.util.List;

@Component
public class StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createStudent(Student student){
        return jdbcTemplate.update("insert into \"Student\" (\"name\", \"surname\", \"patronymic\", " +
                        "\"birth_date\", \"id_group\") values (?, ?, ?, ?, ?)",
                student.getName(), student.getSurname(), student.getPatronymic(), student.getBirthDate(),
                student.getIdGroup());
    }

    public int deleteStudent(int id){
        return jdbcTemplate.update("delete from \"Student\" where \"id\"=?", id);
    }

    public Student getStudent(int id){
        return jdbcTemplate.queryForObject("select * from \"Student\" where \"id\"=?", new StudentMapper(), id);
    }

    public List<Student> getStudentsByGroup(int groupId){
        return jdbcTemplate.query("select * from \"Student\" where \"id\"=?", new StudentMapper(), groupId);
    }

    public List<Student> getStudents(){
        return jdbcTemplate.query("select * from \"Student\"", new StudentMapper());
    }

    public int updateStudent(Student student){
        return jdbcTemplate.update("update \"Student\" set \"name\"=?, \"surname\"=?, \"patronymic\"=?, " +
                        "\"birth_date\"=?, \"id_group\"=? where \"id\"=?",
                student.getName(), student.getSurname(), student.getPatronymic(), student.getBirthDate(),
                student.getIdGroup(), student.getId());
    }
}
