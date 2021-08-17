package com.example.mybatis.mybatisdemo.model;

import com.example.mybatis.mybatisdemo.Service.TestService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Test {

    private int nodeId;

    private double lon;

    private double lat;

    private TestName testName;

    public static void main(String[] args) {

    }
}
