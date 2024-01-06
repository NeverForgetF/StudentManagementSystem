package com.example.dao;

import com.example.entity.Student;

import java.sql.Connection;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentDao {
    public List<Student> getAllStudent(String sql,String stuName,String stuNo,int page,int everyPage){
        System.out.println(sql);
        System.out.println(stuNo+" "+stuName);
        try{
            if ((stuName!=null&&stuNo!=null)&&(!stuNo.equals("")&& !Objects.equals(stuName, ""))){
                return jdbc2.selectList(Student.class,sql,stuName,stuNo,page,everyPage);
            }
            if (stuName!=null&&!stuName.equals("")){
                return jdbc2.selectList(Student.class,sql,stuName,page,everyPage);
            }
            if (stuNo!=null&&!stuNo.equals("")){
                return jdbc2.selectList(Student.class,sql,stuNo,page,everyPage);
            }
            return jdbc2.selectList(Student.class,sql,page,everyPage);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    public Map<String, Object> getCount(String sql,String stuName,String stuNo){
        System.out.println(sql);
        System.out.println(stuNo+" "+stuName);
        try{
            if ((stuName!=null&&stuNo!=null)&&(!stuNo.equals("")&& !Objects.equals(stuName, ""))){
                return jdbc2.selectOne(sql,stuName,stuNo);
            }
            if (stuName!=null&&!stuName.equals("")){
                return jdbc2.selectOne(sql,stuName);
            }
            if (stuNo!=null&&!stuNo.equals("")){
                return jdbc2.selectOne(sql,stuNo);
            }
            return jdbc2.selectOne(sql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public int AddStudent(String sql,List params){
        System.out.println(sql);
        System.out.println(params);
        return jdbc2.doInsert(jdbc2.connection,sql,params.toArray());
    }
    public int delStudent(String sql,String stuId){
        return jdbc2.doUpdate(jdbc2.connection,sql,stuId);
    }
    public Student getStudent(String sql,String id){
        Student student=null;
        try {
            student=jdbc2.selectOne(Student.class,sql,id);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return student;
    }
    public int alterStudent(String sql,List params){
        System.out.println(sql);
        System.out.println(params);
        return jdbc2.doUpdate(jdbc2.connection,sql,params.toArray());
    }
}
