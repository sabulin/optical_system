package webserver.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import webserver.domain.Category;
import webserver.domain.Order;
import webserver.domain.User;
import webserver.service.CategoryService;
import webserver.service.CategoryServiceImpl;
import webserver.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends BaseServlet{
    private OrderService service = new OrderService();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Order> orderList = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),orderList);
    }
    public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(),resultInfo);
        }
        else {
            List<Order> orderList = service.findById(user.getId());
            ObjectMapper mapper = new ObjectMapper();
            request.getSession().setAttribute("orderId",orderList.get(0).getId());
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), orderList);
        }
    }
    public void setIsPaid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        service.setIsPaid((Integer) request.getSession().getAttribute("orderId"));
    }
}
