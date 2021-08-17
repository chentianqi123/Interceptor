package com.example.interceptor.springbootinterceptor.model;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestCalendar {

    public static void main(String[] args){
        TestCalendar testCalendar = new TestCalendar();
        Date date = new Date();
        ArrayList<String> list = new ArrayList<>();
        int count = -5;
        testCalendar.Range(date,list,count);
        System.out.println(JSONObject.toJSONString(list));
    }

    //递归方法（3要素）1：方法的作用   2：方法的结束条件  3：找出函数的等价关系
    public void Range(Date date,List<String> list ,int count){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //找到当前时间6周前的周一（因为getDayRange中返回的是周一）
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH,count);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        Date time = calendar.getTime();
        if(dateFormat.format(date).equals(dateFormat.format(time))){   //递归 直到找到6周前的 周一
            return;
        }
        //根据当前时间去查找上一周的周一和周日
        Date dayRange = getDayRange(date, list);
        Range(dayRange,list,count);  //找到上一周的周一和周日，继续执行这个方法，继续查找往前一周的周一和周日
    }


    public Date getDayRange(Date date, List<String> list){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //根据date获取上周一
        calendar.add(Calendar.WEEK_OF_YEAR,-1);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        Date montime = calendar.getTime();

        //根据date获取上周日
        calendar.add(Calendar.WEEK_OF_YEAR,1); //当周的周日，就是下周的第一天，WEEK_OF_YEAR要加1
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        Date Suntime = calendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        list.add(dateFormat.format(montime)+"~"+dateFormat.format(Suntime));//输出每个时间端的周一到周五
        //返回上一周的周一，继续来找上上周
        return montime;
    }


}
