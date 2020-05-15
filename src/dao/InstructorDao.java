package dao;

import domain.Instructor;
import domain.Student;

/**
 * @author liyu
 */
public interface InstructorDao {
    /**
     * 登录验证
     * @param i
     * @return
     */
    public Instructor login(Instructor i);
}
