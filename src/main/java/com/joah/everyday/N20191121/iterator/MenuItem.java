package com.joah.everyday.N20191121.iterator;

import lombok.Data;

@Data
public class MenuItem {

    private String name;

    private String description;

    private int channe;

    public MenuItem(int channe, String name, String description){
        this.name = name;
        this.channe = channe;
        this.description = description;
    }
}
