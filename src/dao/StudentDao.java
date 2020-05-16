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
     * @return 返回查询到的所有学生的信息，用List存储
     */
    public List<Student> getStudent(Instructor i);

    /**
     * 往数据库中添加学生
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
     * 更新学生信息
     * @param s 新的学生信息
     */
    public void updateStudent(Student s);

    /**
     * 删除指定id的学生
      * @param id 学生id
     */
    public void deleteStudent(String id);
}

