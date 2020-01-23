package com.joah.everyday.N2019.N201911.N20191121.commands;

public class OpenTvCommand implements Command{

    private Television tv;

    public OpenTvCommand(){
        tv = new Television();
    }

    @Override
    public void excute(int i) {
        tv.open();
    }
}
