package webserver.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import webserver.domain.Frame;
import webserver.domain.Lens;
import webserver.util.JDBCUtils;

import java.util.List;

public class FrameDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Frame> findAll(){
        String sql = "SELECT DISTINCT categoryName,frameName,DESCRIPTION,kind FROM frame NATURAL JOIN category";
        return template.query(sql,new BeanPropertyRowMapper<Frame>(Frame.class));
    }
}