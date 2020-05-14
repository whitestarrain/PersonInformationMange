package service.impl;

import dao.impl.StudentDaoImpl;
import domain.Instructor;
import domain.Student;
import service.StudentService;

import java.util.List;

/**
 * @author liyu
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudent(Instructor i) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.getStudent(i);
    }
}
