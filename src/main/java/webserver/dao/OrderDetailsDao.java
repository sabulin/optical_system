package webserver.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import webserver.domain.Order;
import webserver.domain.OrderDetails;
import webserver.util.JDBCUtils;

import java.util.List;

public class OrderDetailsDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<OrderDetails> findAll(){
        String sql1 = "SELECT * FROM orderdetails NATURAL JOIN lens";
        String sql2 = "SELECT * FROM orderdetails NATURAL JOIN frame";
        List<OrderDetails> list1 = template.query(sql1,new BeanPropertyRowMapper<OrderDetails>(OrderDetails.class));
        List<OrderDetails> list2 = template.query(sql2,new BeanPropertyRowMapper<OrderDetails>(OrderDetails.class));
        list1.addAll(list2);
        return  list1;
//      return template.query(sql1,new BeanPropertyRowMapper<OrderDetails>(OrderDetails.class));
    }

    public List<OrderDetails> findById(Integer orderId) {
        System.out.println("orderId:"+orderId);
        String sql1 = "SELECT * FROM orderdetails NATURAL JOIN lens where orderId = ?";
        String sql2 = "SELECT * FROM orderdetails NATURAL JOIN frame where orderId = ?";
        List<OrderDetails> list1 = template.query(sql1,new BeanPropertyRowMapper<OrderDetails>(OrderDetails.class),orderId);
        List<OrderDetails> list2 = template.query(sql2,new BeanPropertyRowMapper<OrderDetails>(OrderDetails.class),orderId);
        list1.addAll(list2);
        return list1;
    }
    public boolean add(OrderDetails orderDetails) {
        if(orderDetails.getFrameId()!=null){
            String sql = "INSERT INTO orderdetails (orderId,lensId,frameId) VALUES(?,NULL,?)";
            //2.执行 sql
            template.update(sql,orderDetails.getOrderId(),orderDetails.getFrameId());
            return true;
        }
        else {
            String sql = "INSERT INTO orderdetails (orderId,lensId,frameId) VALUES(?,?,NULL)";
            //2.执行 sql
            template.update(sql,orderDetails.getOrderId(),orderDetails.getLensId());
            return true;
        }
    }

}