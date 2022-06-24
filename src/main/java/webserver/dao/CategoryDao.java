package webserver.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import webserver.domain.Category;
import webserver.util.JDBCUtils;


import java.util.List;

public class CategoryDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Category> findAll(){
        String sql = "select * from category";
        System.out.println(template.query(sql,new BeanPropertyRowMapper<Category>(Category.class)));
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}