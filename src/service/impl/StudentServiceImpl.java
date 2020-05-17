package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Instructor;
import domain.PageBean;
import domain.Student;
import service.StudentService;

import java.util.List;

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
    public PageBean<Student> getStudentByPage(int row, int currentPage) {
        PageBean<Student> studentPageBean = new PageBean<>();
        studentPageBean.setCurrentPage(currentPage);
        studentPageBean.setList(dao.getStudentByPage(row,currentPage));
        int totalCount=dao.getAllCount();
        studentPageBean.setTotalCount(totalCount);
        studentPageBean.setTotalPage((totalCount%row==0)?totalCount/row:totalCount/row+1);

        return studentPageBean;
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
