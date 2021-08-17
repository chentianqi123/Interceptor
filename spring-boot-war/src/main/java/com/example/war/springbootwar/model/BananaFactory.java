package com.example.war.springbootwar.model;

public class BananaFactory extends AbsFactory {
    @Override
    public Fruit newFruit() {
        Banana banana = new Banana();
        return banana;
    }
}
