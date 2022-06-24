package webserver.service;

import com.sun.tools.corba.se.idl.constExpr.Or;
import webserver.dao.CategoryDao;
import webserver.dao.LensDao;
import webserver.dao.OrderDao;
import webserver.domain.Category;
import webserver.domain.Lens;
import webserver.domain.Order;
import webserver.domain.User;

import java.util.List;

public class OrderService{
    private OrderDao orderDao = new OrderDao();
    public List<Order> findAll(){
        return orderDao.findAll();
    }
    public List<Order> findById(Integer userId){
        if(orderDao.findById(userId).isEmpty()){
            Order order = new Order();
            order.setEmployeeId(1);
            order.setTotalPrice(0.0);
            order.setIsPaid(0);
            order.setUserId(userId);
            orderDao.add(order);
        }
        return orderDao.findById(userId);
    }
    public void setIsPaid(Integer orderId){
        orderDao.setIsPaid(orderId);
    }


}