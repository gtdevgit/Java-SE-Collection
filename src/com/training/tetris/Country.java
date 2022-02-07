package com.training.tetris;

public class Country {
    String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int compare(Country c){
        return this.name.compareToIgnoreCase(c.name);
    }
}
