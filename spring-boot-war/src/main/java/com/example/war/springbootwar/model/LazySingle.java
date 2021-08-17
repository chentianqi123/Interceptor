package com.example.war.springbootwar.model;

public class LazySingle {

    public static LazySingle instance = null;

    public LazySingle() {
    }

    public static LazySingle getInstance(){
        if(instance == null){
            instance = new LazySingle();
        }else{
            System.out.println("已经产生一个对象，不能产生新得对象");
        }
        return instance;
    }
}
