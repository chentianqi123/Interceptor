package com.example.war.springbootwar.model;

public class Prototype implements Cloneable {

    private  String name;


    public Prototype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone(){
        System.out.println("具体原型复制成功！");
        try {
            return (Prototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
