package service;

import domain.Instructor;
import domain.PageBean;
import domain.Student;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据指定id删除学生
     * @param id 学生id
     */
    public void deleteStudent(String id);

    /**
     * 删除所选学生
     * @param sids 学生id列表
     */
    void deleteSelectedStudent(String[] sids);

    /**
     * 根据页数获取部分学生
     * @param row 每页多少行
     * @param currentPage 要获取的当前页数
     * @return 查到的学生集合
     */
    PageBean<Student> getStudentByPage(int row, int currentPage);

    /**
     * 通过搜索条件返回最终结果
     * @param map 查询条件
     * @param row 每页列数
     * @param currentPage 当前页
     * @return 分页list信息
     */
    PageBean<Student> searchStudent(Map<String,String> map,int row,int currentPage);

    /**
     * 检查学生id是否在数据库中存在,存在为true
     * @param id 学生id
     * @return json字符串
     */
    String checkId(String id);
}
