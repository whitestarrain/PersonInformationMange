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
     * @param i 教员对象
     * @return
     */
    public List<Student> getStudent(Instructor i);

    /**
     * 添加学生
     * @param s 学生对象
     */
    public void addStudent(Student s);

    /**
     * 根据学生id返回学生对象
     * @param id 学生id
     * @return 学生对象
     */
    public Student findStudent(String id);

    /**
     * 更新学生数据
     * @param s 新的学生数据保存对象
     */
    public void updateStudent(Student s);
}
