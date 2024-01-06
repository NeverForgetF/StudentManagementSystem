package com.example.dao;

import com.example.entity.User;

import java.util.List;

public class UserDao {
    public User getUser(String sql,String loginName){
        User user=null;
        try {
            user = jdbc2.selectOne(User.class,sql,loginName);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}
