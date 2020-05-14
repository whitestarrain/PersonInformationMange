package service;

import domain.Instructor;
import domain.Student;

import java.util.List;

/**
 * @author liyu
 */
public interface StudentService {
    /**
     * 用来获取学生信息
     *
     * @param i 教员信息
     * @return
     */
    public List<Student> getStudent(Instructor i);
}
