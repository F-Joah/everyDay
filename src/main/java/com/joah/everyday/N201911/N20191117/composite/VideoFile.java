package com.joah.everyday.N201911.N20191117.composite;

public class VideoFile extends File{

    public VideoFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是影像文件，文件名：" + super.getName() );
    }
}
