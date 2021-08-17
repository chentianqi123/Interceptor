package com.example.mybatis.mybatisdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Node {

    private int nodeId;

    private double lon;

    private double lat;

    private TestName testName;
}
