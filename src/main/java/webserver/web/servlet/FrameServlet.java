package webserver.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import webserver.domain.Frame;
import webserver.domain.Lens;
import webserver.domain.User;
import webserver.service.FrameService;
import webserver.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/frame/*")
public class FrameServlet extends BaseServlet {
    private FrameService service = new FrameService();
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Frame> frameList = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(frameList);
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),frameList);
    }
}
