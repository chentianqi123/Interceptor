package com.example.mybatis.mybatisdemo.Service;

public interface TestService {

    default String getName(){
        return "我是接口";
    }
}
