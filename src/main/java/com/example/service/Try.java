package com.example.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Try {
    public String getDate(){
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    public static void main(String[] args) {

        System.out.println(new Try().getDate());
    }
}
