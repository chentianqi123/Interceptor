package com.example.war.springbootwar.model;

public class Son1 extends FactoryFather {

    @Override
    public void start() {
        System.out.println("这是简单工厂的第一个实例son1");
    }
}
