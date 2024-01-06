package com.example.service;

import com.example.dao.GradeDao;
import com.example.entity.Grade;

import java.util.List;

public class GradeService {
    GradeDao gradeDao=new GradeDao();
    public List<Grade> getGrade(String sql){
        return gradeDao.getGrade(sql);
    }
}
