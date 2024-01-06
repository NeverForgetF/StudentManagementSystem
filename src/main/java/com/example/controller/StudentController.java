package com.example.controller;

import com.example.entity.Grade;
import com.example.entity.Student;
import com.example.service.GradeService;
import com.example.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet(urlPatterns = "/list")
public class StudentController extends BaseServlet {
    StudentService studentService=new StudentService();
    public List getParams(HttpServletRequest request,HttpServletResponse response){
        String stuName=request.getParameter("stuName");
        String gId=request.getParameter("grade");
        String sex=request.getParameter("sex");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String registered=request.getParameter("registered");
        String address=request.getParameter("address");
        String politics=request.getParameter("politics");
        String idNumber=request.getParameter("idNumber");
        String profession=request.getParameter("profession");
        String introduction=request.getParameter("introduction");
        List params=new ArrayList();
        params.add(stuName);
        params.add(gId);
        params.add(sex);
        params.add(email);
        params.add(phone);
        params.add(registered);
        params.add(address);
        params.add(politics);
        params.add(idNumber);
        params.add(profession);
        params.add(introduction);
        return params;
    }
    public void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuName=request.getParameter("stuName");
        String stuNo=request.getParameter("stuNo");
        String sex=request.getParameter("sex");
        StringBuffer sql=new StringBuffer("select * from student where 1=1 ");
        StringBuffer sql2=new StringBuffer("SELECT COUNT(*) count FROM student where 1=1");
        if (stuName!=null&&!stuName.equals("")){
            sql.append(" and stuName like ? ");
            sql2.append(" and stuName like ? ");
        }
        request.setAttribute("stuName",stuName);
        if (stuNo!=null&&!stuNo.equals("")){
            sql.append(" and stuNo like ? ");
            sql2.append(" and stuNo like ? ");
        }
        request.setAttribute("stuNo",stuNo);
        if (Objects.equals(sex, "1") || Objects.equals(sex, "2")){
            sql.append(" and sex= ");
            sql.append(sex);
            sql2.append(" and sex= ");
            sql2.append(sex);
        }
        request.setAttribute("sex",sex);
        sql.append(" limit ?,?");
        int page= Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"));
        int everyPage=10;
        int beginNum=(page-1)*everyPage;
        List<Student> studentList =  studentService.getAllStudent(String.valueOf(sql),stuName,stuNo,beginNum,everyPage);
        request.setAttribute("studentList",studentList);
        Map<String, Object> count=studentService.getCount(String.valueOf(sql2),stuName,stuNo);
        int allStu=Integer.parseInt(String.valueOf(count.get("count")));
        int allPage=(allStu%everyPage!=0)?(allStu/everyPage+1):(allStu/everyPage);
        request.setAttribute("page",page);
        request.setAttribute("allPage",allPage);
        request.getRequestDispatcher("Educational/student/list.jsp").forward(request,response);
    }
    public void addStudent(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String stuNo=request.getParameter("stuNo");
        List params=getParams(request,response);
        params.add(stuNo);
        Date regDate= Date.valueOf(new Student().getLoginDate());
        params.add(regDate);
        String sql="Insert into student(stuName,gId,sex,email,phone,registered,address,politics,idNumber,profession,introduction,stuNo,regDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int flag=studentService.AddStudent(sql,params);
        System.out.println("增加"+flag+"学生");
        if (flag>0){
            request.setAttribute("flag","true");
            new StudentController().getAllStudent(request,response);
        }else {
            new GradeController().service(request,response);
        }
    }
    public void delStudent(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String stuId= request.getParameter("stuId");
        String sql="delete from student where stuId=?";
        int flag=studentService.delStudent(sql,stuId);
        PrintWriter printWriter=response.getWriter();
        System.out.println("删除"+flag+"学生");
        if (flag>0){
            printWriter.println("<script>alert('删除成功');</script>");
        }else {
            printWriter.println("<script>alert('删除失败');</script>");
        }
        new StudentController().getAllStudent(request,response);
    }
    public void alterStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String stuNo=request.getParameter("stuNo");
        System.out.println("alter--"+stuNo);
        String stuId=request.getParameter("stuId");
        List params=getParams(request,response);
        params.add(stuId);
        String sql="update student set stuName=?,gId=?,sex=?,email=?,phone=?,registered=?,address=?,politics=?,idNumber=?,profession=?,introduction=? where stuId=?";
        int flag=studentService.alterStudent(sql,params);
        PrintWriter printWriter=response.getWriter();
        System.out.println("更新"+flag+"学生");
        if (flag>0){
            printWriter.println("<script>alert('更新成功');</script>");
        }else {
            printWriter.println("<script>alert('更新失败');</script>");
        }
        request.setAttribute("flag","true");
        new StudentController().getAllStudent(request,response);
    }
}
