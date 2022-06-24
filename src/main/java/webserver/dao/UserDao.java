package webserver.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import webserver.domain.Category;
import webserver.domain.User;
import webserver.util.JDBCUtils;


import java.util.List;

public class UserDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void findAll(){
    }

    public boolean save(User user) {
        System.out.println("ljx"+user.getTelephone());
        String sql = "insert into user(name,telephone,password) values(?,?,?)";
        //2.执行 sql

        template.update(sql,
                user.getName(),
                user.getTelephone(),
                user.getPassword());
        return true;
    }
    public User findByTelephone(String telephone) {
        User user = null;
        try {
            //1.定义 sql
            String sql = "select * from user where telephone = ?";
            //2.执行 sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),telephone);
        } catch (Exception e) {
        }
        return user;
    }

    public User findByTelephoneAndPassword(String telephone ,String password) {
        User user = null;
        try {
            //1.定义 sql
            String sql = "select * from user where telephone = ? and password = ?";
            //2.执行 sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),telephone,password);
            System.out.println("Dao"+user);
        } catch (Exception e) {
        }
        return user;
    }
}