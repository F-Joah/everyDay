package com.joah.everyday.N2019.N201911.N20191117.composite;

public class TextFile extends File {

    public TextFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是文本文件夹，文件名：" + super.getName() );
    }
}
