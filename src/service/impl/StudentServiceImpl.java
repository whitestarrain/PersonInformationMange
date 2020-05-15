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
    public void addStudent(Student s) {
        dao.addStudent(s);
    }

    @Override
    public List<Student> getStudent(Instructor i) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.getStudent(i);
    }
}
