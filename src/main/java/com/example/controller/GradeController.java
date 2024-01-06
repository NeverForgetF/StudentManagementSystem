package com.example.controller;

import com.example.entity.Grade;
import com.example.entity.Student;
import com.example.service.GradeService;
import com.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/grade")
public class GradeController extends HttpServlet {
    GradeService gradeService=new GradeService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql="SELECT * FROM grade";
        List<Grade> gradeList=gradeService.getGrade(sql);
        req.setAttribute("gradeList",gradeList);
        String means = req.getParameter("means");
        System.out.println(means);
        if (means.equals("add")){
            req.getRequestDispatcher("Educational/student/add.jsp").forward(req,resp);
        }else {
            String stuId=req.getParameter("stuId");
            String sql2="SELECT * FROM student where stuId=?";
            Student student=new StudentService().getStudent(sql2,stuId);
            req.setAttribute("student",student);
            req.getRequestDispatcher("Educational/student/edit.jsp").forward(req,resp);
        }
    }
}
