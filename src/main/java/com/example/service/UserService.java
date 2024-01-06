package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;

public class UserService {
    UserDao userDao=new UserDao();
    public User getUser(String sql,String loginName,String passWord){
        User user=userDao.getUser(sql,loginName);
        if (user!=null && user.getLoginName()!=null){
            if (passWord.equals(user.getPassWord())){
                return user;
            }
        }
        return null;
    }
}
