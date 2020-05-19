package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Instructor;
import domain.PageBean;
import domain.Student;
import service.StudentService;

import java.util.List;
import java.util.Map;

/**
 * @author liyu
 */
public class StudentServiceImpl implements StudentService {
    StudentDao dao=new StudentDaoImpl();

    @Override
    public void updateStudent(Student s) {
        dao.updateStudent(s);
    }

    @Override
    public Student findStudent(String id) {
        Student student = dao.findStudent(id);
        return student;
    }

    @Override
    public PageBean<Student> searchStudent(Map<String, String> map,int row ,int currentPage) {
        return getStudentByPageCondition(map,row,currentPage);
    }
    private PageBean<Student> getStudentByPageCondition(Map<String,String> condition, int row, int currentPage){
        PageBean<Student> studentPageBean = new PageBean<>();
        studentPageBean.setList(dao.getStudentByPage(condition,row,currentPage));
        int totalCount=dao.getAllCount(condition);
        studentPageBean.setTotalCount(totalCount);
        int totalPage=(totalCount%row==0)?totalCount/row:totalCount/row+1;
        studentPageBean.setTotalPage(totalPage);
        studentPageBean.setCurrentPage(Math.min(currentPage, totalPage));

        return studentPageBean;
    }
    @Override
    public PageBean<Student> getStudentByPage(int row, int currentPage) {

        return getStudentByPageCondition(null,row,currentPage);
    }

    @Override
    public void deleteSelectedStudent(String[] sids) {
        if (sids!=null&&sids.length>0){
            for(String s:sids){
                deleteStudent(s);
            }
        }
    }

    @Override
    public void deleteStudent(String id) {
        dao.deleteStudent(id);
    }

    @Override
    public void addStudent(Student s) {
        dao.addStudent(s);
    }

    @Override
    public List<Student> getStudent(Instructor i) {
        return dao.getStudent(i);
    }
}
