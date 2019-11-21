package com.joah.everyday.N20191121.commands;

public class ChangeChannelCommand implements Command {

    private Television tv;

    public ChangeChannelCommand(){
        tv = new Television();
    }

    @Override
    public void excute(int i) {
        tv.changeChannel();
        System.out.println("....当前频道" + i);
    }
}
