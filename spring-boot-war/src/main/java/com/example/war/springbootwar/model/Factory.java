package com.example.war.springbootwar.model;

public class Factory {

    public FactoryFather getSon(String son) {
        FactoryFather s = null;
        if ("1".equals(son)) {
            s = new Son1();
        } else {
            s = new Son2();
        }
        return s;
    }
}
