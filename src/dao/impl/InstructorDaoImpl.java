package dao.impl;

import dao.InstructorDao;
import domain.Instructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

/**
 * @author liyu
 */
public class InstructorDaoImpl implements InstructorDao {

    @Override
    public Instructor login(Instructor i) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSourse());
        String sql = "select * from instructor where id=? and password=?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Instructor>(Instructor.class), i.getId(), i.getPassword());
        }catch(Exception e){
            return null;
        }
    }
}
