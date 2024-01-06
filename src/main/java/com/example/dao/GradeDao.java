package com.example.dao;

import com.example.entity.Grade;

import java.util.List;

public class GradeDao {
    public List<Grade> getGrade(String sql){
        return jdbc2.selectList(Grade.class,sql);
    }
}
