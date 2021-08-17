package com.example.mybatis.mybatisdemo.model;

public class User {

    private int ID;

    private int userid;

    private String deleted;

    private String name;

    private int age;

    private String area;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDelete() {
        return deleted;
    }

    public void setDelete(String deleted) {
        this.deleted = deleted;
    }

    public User() {
    }

    public User(String name, int age, String area) {
        this.name = name;
        this.age = age;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
