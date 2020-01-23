package com.joah.everyday.N2019.N201911.N20191117.composite;

public abstract class File {

    String name;

    public File(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public abstract void display();
}
