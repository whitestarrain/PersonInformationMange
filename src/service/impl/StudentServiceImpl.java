package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Instructor;
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
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.getStudent(i);
    }
}
