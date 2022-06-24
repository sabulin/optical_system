package webserver.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import webserver.dao.OrderDetailsDao;
import webserver.domain.Order;
import webserver.domain.OrderDetails;
import webserver.domain.User;
import webserver.service.OrderDetailsService;
import webserver.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/orderDetails/*")
public class OrderDetailsServlet extends BaseServlet{
    private OrderDetailsService service = new OrderDetailsService();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<OrderDetails> orderDetailsList = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orderDetailsList);
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),orderDetailsList);
    }
    public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer orderId = (Integer) request.getSession().getAttribute("orderId");
        if(orderId == null){
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(),resultInfo);
        }
        else {
            System.out.println("servlet"+orderId);
            List<OrderDetails> orderDetailsList = service.findById(orderId);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(orderDetailsList));
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), orderDetailsList);
        }
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer orderId = (Integer) request.getSession().getAttribute("orderId");
        Map<String, String[]> map = request.getParameterMap();
        request.setCharacterEncoding("UTF-8");
        OrderDetails orderDetails = new OrderDetails();
        try {
            BeanUtils.populate(orderDetails, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        orderDetails.setOrderId(orderId);
        service.add(orderDetails);
    }
}
