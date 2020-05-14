package service.impl;

import dao.impl.InstructorDaoImpl;
import domain.Instructor;
import service.InstructorService;

/**
 * @author liyu
 */
public class InstructerServiceImpl implements InstructorService {
    @Override
    public Instructor login(Instructor i) {
        InstructorDaoImpl instructorDao = new InstructorDaoImpl();
        return instructorDao.login(i);
    }
}
