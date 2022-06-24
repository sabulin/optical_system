package webserver.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import webserver.domain.Category;
import webserver.domain.Order;
import webserver.domain.User;
import webserver.util.JDBCUtils;

import java.util.List;

public class OrderDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Order> findAll(){
        String sql = "select * from order";
        System.out.println(template.query(sql,new BeanPropertyRowMapper<Order>(Order.class)));
        return template.query(sql,new BeanPropertyRowMapper<Order>(Order.class));
    }

    public List<Order> findById(Integer userId) {
        String sql = "select * from orders where userId = ? and isPaid = false";
        System.out.println(template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),userId));
        return template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),userId);
    }
    public boolean add(Order order) {
        String sql = "INSERT INTO orders (userId,employeeId,totalPrice,isPaid) VALUES(?,?,?,?)";
        //2.执行 sql
        template.update(sql,
                order.getUserId(),
                order.getEmployeeId(),
                order.getTotalPrice(),
                order.getIsPaid()
                );
        return true;
    }
    public boolean setIsPaid(Integer orderId) {
        String sql = "UPDATE orders SET isPaid = 1 WHERE id = ?";
        //2.执行 sql
        template.update(sql,orderId);
        return true;
    }

}