package com.example.mybatis.mybatisdemo.mapper;

import com.example.mybatis.mybatisdemo.model.Node;
import com.example.mybatis.mybatisdemo.model.Test;
import com.example.mybatis.mybatisdemo.model.TestName;
import com.example.mybatis.mybatisdemo.model.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TestMapper {


    List<Test> queryNode();


    TestName queryNodeName(@Param("nodeId")int nodeId);

    /*List<Test> query();


    List<Node> queryNodes();

    List<TestName> queryNodeNameList(@Param("nodeId")int nodeId);

    List<Node> queryList();*/
}
