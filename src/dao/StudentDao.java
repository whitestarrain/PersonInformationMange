package dao;

import domain.Instructor;
import domain.Student;

import java.util.List;

/**
 * @author liyu
 */
public interface StudentDao {
    /**
     * 查询数据库获得学生信息
     * @param i 教员信息
     * @return
     */
    public List<Student> getStudent(Instructor i);
}
