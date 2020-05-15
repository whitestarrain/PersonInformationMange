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
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSourse());

    @Override
    public Student findStudent(String id) {
        String sql="select * from student where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }

    @Override
    public void updateStudent(Student s) {
        String sql="update student set name=?,deptName=?,totCred=? where id=?";
        jdbcTemplate.update(sql,s.getName(),s.getDeptName(),s.getTotCred(),s.getId());
    }

    @Override
    public void addStudent(Student s) {
        String sql = "insert into student values(?,?,?,?)";
        jdbcTemplate.update(sql, s.getId(), s.getName(), s.getDeptName(), s.getTotCred());
    }

    @Override
    public List<Student> getStudent(Instructor i) {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
    }
}
