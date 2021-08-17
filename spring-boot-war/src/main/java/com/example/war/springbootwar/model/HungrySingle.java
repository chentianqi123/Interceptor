package com.example.war.springbootwar.model;

public class HungrySingle {

    public static HungrySingle hungrySingle = new HungrySingle();

    public HungrySingle() {
    }

    public static HungrySingle getInstance(){
        return hungrySingle;
    }
}
