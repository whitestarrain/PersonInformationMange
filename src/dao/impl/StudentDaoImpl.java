package dao.impl;

import dao.StudentDao;
import domain.Instructor;
import domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.util.List;

/**
 * @author liyu
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent(Student s) {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSourse());
        String sql="insert into student values(?,?,?,?)";
        jdbcTemplate.update(sql,s.getId(),s.getName(),s.getDeptName(),s.getTotCred());
    }

    @Override
    public List<Student> getStudent(Instructor i) {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSourse());
        String sql="select * from student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
    }
}
