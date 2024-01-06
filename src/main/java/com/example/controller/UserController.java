package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class UserController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName= req.getParameter("TxtUserName");
        String passWord=req.getParameter("TxtPassword");
        String sql="SELECT * FROM users where loginName=?";
        User user=userService.getUser(sql,loginName,passWord);
        if (user==null){
            resp.sendRedirect("view/login.jsp");
        }else {
            req.getSession().setAttribute("user",user);
            System.out.println(user.getLoginName());
            req.getRequestDispatcher("view/index.jsp").forward(req,resp);
        }
    }
}
