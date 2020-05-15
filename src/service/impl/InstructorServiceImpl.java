package service.impl;

import dao.InstructorDao;
import dao.impl.InstructorDaoImpl;
import domain.Instructor;
import service.InstructorService;

/**
 * @author liyu
 */
public class InstructorServiceImpl implements InstructorService {
    private InstructorDao dao = new InstructorDaoImpl();

    @Override
    public Instructor login(Instructor i) {
       return dao.login(i);
    }
}
