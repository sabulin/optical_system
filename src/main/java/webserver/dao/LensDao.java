package webserver.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import webserver.domain.Category;
import webserver.domain.Lens;
import webserver.util.JDBCUtils;

import java.util.List;

public class LensDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Lens> findAll(){
        String sql = "SELECT DISTINCT categoryName,lensName,DESCRIPTION,kind FROM lens NATURAL JOIN category";
        return template.query(sql,new BeanPropertyRowMapper<Lens>(Lens.class));
    }
}