package dao.impl;

import dao.StudentDao;
import domain.Instructor;
import domain.PageBean;
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
    public int getAllCount() {
        String sql="select count(id) from student";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public List<Student> getStudentByPage(int row, int currentPage) {
        int allCount=this.getAllCount();
        int c=currentPage;
        int allpage = (allCount % row == 0) ? allCount / row : allCount / row + 1;
        if(currentPage> (allpage)){
            c= allpage;
        }
        int start=(c-1)*row;
        String sql="select * from student limit ?,?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), start, row);
    }

    @Override
    public void deleteStudent(String id) {
        String sql = "delete from student where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Student findStudent(String id) {
        String sql = "select * from student where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }

    @Override
    public void updateStudent(Student s) {
        String sql = "update student set name=?,deptName=?,totCred=? where id=?";
        jdbcTemplate.update(sql, s.getName(), s.getDeptName(), s.getTotCred(), s.getId());
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
