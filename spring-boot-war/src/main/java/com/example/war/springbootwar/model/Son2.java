package com.example.war.springbootwar.model;

public class Son2 extends FactoryFather {
    @Override
    public void start() {
        System.out.println("这是简单工厂的第二个实例son2");
    }
}
