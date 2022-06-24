package webserver;

import org.junit.Assert;
import org.junit.Test;
import webserver.domain.User;
import webserver.service.UserService;

public class MainTest {
    @Test
    public void method(){
        UserService userService = new UserService();
        User user = new User();
        //userService.register();
    }
}
