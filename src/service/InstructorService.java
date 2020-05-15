package service;

import domain.Instructor;

/**
 * @author liyu
 */
public interface InstructorService {
    /**
     * 登录验证
     * @param i 登录教员
     * @return 信息正确，返回登录教员全部信息。否则返回null
     */
    public Instructor login(Instructor i);
}
