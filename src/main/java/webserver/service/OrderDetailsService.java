package webserver.service;

import webserver.dao.OrderDao;
import webserver.dao.OrderDetailsDao;
import webserver.domain.Order;
import webserver.domain.OrderDetails;

import java.util.List;

public class OrderDetailsService {
    private OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
    public List<OrderDetails> findAll(){
        return orderDetailsDao.findAll();
    }
    public List<OrderDetails> findById(Integer orderId){
        return orderDetailsDao.findById(orderId);
    }
    public Boolean add(OrderDetails orderDetails){
        orderDetailsDao.add(orderDetails);
        return true;
    }
}