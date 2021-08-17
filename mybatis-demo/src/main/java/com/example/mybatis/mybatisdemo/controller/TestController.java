package com.example.mybatis.mybatisdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.mybatisdemo.mapper.TestMapper;
import com.example.mybatis.mybatisdemo.model.Node;
import com.example.mybatis.mybatisdemo.model.Test;
import com.example.mybatis.mybatisdemo.model.User;
import com.example.mybatis.mybatisdemo.util.PageUtil;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TestController{

    @Resource
    TestMapper testMapper;

    @GetMapping("/test")
    public void test(){
        List<Test> tests = testMapper.queryNode();
        for(Test te:tests){
            System.out.println(JSONObject.toJSONString(te));
        }
    }


}
