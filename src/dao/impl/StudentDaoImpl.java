package dao.impl;

import dao.StudentDao;
import domain.Instructor;
import domain.Student;
import jdk.jfr.StackTrace;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liyu
 */
public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSourse());

    @Override
    public Boolean checkId(String id) {
        if(id==null||id==""){
            return false;
        }
        String sql="select count(id) from student where id = ?";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return integer>0;
    }

    @Override
    public int getAllCount(Map<String, String> condition) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(id) from student where 1=1 ");
        List<Object> param=new ArrayList<>();
        if(condition!=null){
            Set<String> keySet = condition.keySet();
            for (String s : keySet) {
                if (condition.get(s) != null) {
                    sb.append(" and ").append(s).append(" like ").append(" ? ");
                    param.add("%" + condition.get(s) + "%");
                }
            }
        }
        Integer integer = jdbcTemplate.queryForObject(sb.toString(), Integer.class,param.toArray());
        return integer;
    }

    @Override
    public List<Student> getStudentByPage(Map<String, String> condition, int row, int currentPage) {
        int allCount = this.getAllCount(condition);
        int c = currentPage;
        int allpage = (allCount % row == 0) ? allCount / row : allCount / row + 1;
        if (currentPage > (allpage)) {
            c = allpage;
        }
        int start = (c - 1) * row;

        StringBuilder sb = new StringBuilder();
        sb.append("select * from student where 1=1 ");
        List<Object> param=new ArrayList<>();
        if(condition!=null){
            Set<String> keySet = condition.keySet();
            for (String s : keySet) {
                if (condition.get(s) != null) {
                    sb.append(" and ").append(s).append(" like ").append(" ? ");
                    param.add("%" + condition.get(s) + "%");
                }
            }
        }
        sb.append(" limit ?,? ");
        param.add(start);
        param.add(row);
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<Student>(Student.class), param.toArray());
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
