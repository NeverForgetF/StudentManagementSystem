package com.example.service;

import com.example.dao.StudentDao;
import com.example.dao.jdbc2;
import com.example.entity.Student;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class StudentService {
    StudentDao studentDao=new StudentDao();
    public List<Student> getAllStudent(String sql,String stuName,String stuNo,int page,int everyPage){
        return studentDao.getAllStudent(sql,stuName,stuNo,page,everyPage);
    }
    public Map<String, Object> getCount(String sql,String stuName,String stuNo){
        return studentDao.getCount(sql,stuName,stuNo);
    }
//    public int AddStudent(String sql, String stuNo, String stuName, String gId, String sex, String email, String phone, String registered, String address, String politics, String idNumber, String profession, String introduction, Date regDate){
//        return studentDao.AddStudent(sql,stuNo,stuName,gId,sex,email,phone,registered,address,politics,idNumber,profession,introduction,regDate);
//    }
    public int AddStudent(String sql,List params){
        return studentDao.AddStudent(sql,params);
    }
    public int delStudent(String sql,String stuId){
        return studentDao.delStudent(sql,stuId);
    }
    public Student getStudent(String sql,String id){
        return studentDao.getStudent(sql,id);
    }
    public int alterStudent(String sql,List params){
        return studentDao.alterStudent(sql,params);
    }
}
