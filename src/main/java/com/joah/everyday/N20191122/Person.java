package com.joah.everyday.N20191122;

public abstract class Person {

    protected String name;
    protected Mediator mediator;

    Person(String name,Mediator mediator){
        this.name = name;
        this.mediator = mediator;
    }

}
