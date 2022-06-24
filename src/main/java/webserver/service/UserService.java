package webserver.service;

import webserver.dao.UserDao;
import webserver.domain.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public boolean register(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByTelephone(user.getTelephone());
        //判断 u 是否为 null
        if(u != null){
            //手机号存在，注册失败
            System.out.println("error");
            return false;
        }
        //2.保存用户信息
        else{
            System.out.println("sucess");
            return userDao.save(user);
        }

    }

    public User login(String telephone ,String password) {
        User user = userDao.findByTelephoneAndPassword(telephone,password);
        System.out.println("service"+user);
        return user;
    }
}