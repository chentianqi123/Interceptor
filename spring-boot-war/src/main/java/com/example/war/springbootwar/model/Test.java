package com.example.war.springbootwar.model;

import ch.qos.logback.core.joran.spi.JoranException;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListenerFactory;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.Resource;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Transactional
public class Test{


    public static void main(String[] args){
        Function<Integer,String[]> fc = String[]::new;
        String[] strings = fc.apply(6);
        System.out.println(strings.length);
    }

    public void print(Integer s){
        System.out.println(s);
    }
}
