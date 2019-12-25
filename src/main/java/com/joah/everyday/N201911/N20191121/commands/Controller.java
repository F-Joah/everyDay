package com.joah.everyday.N201911.N20191121.commands;

public class Controller {

    private Command openTvCommand;

    private Command closeTvCommand;

    private Command changeChannelCommand;

    public int nowChannel = 0;
    public int priorChannel;

    public Controller(Command openTvCommand, Command closeTvCommand, Command changeChannelCommand){
        this.openTvCommand = openTvCommand;
        this.closeTvCommand = closeTvCommand;
        this.changeChannelCommand = changeChannelCommand;
    }

    /**
     * 打开电视机
     */
    public void open(){
        openTvCommand.excute(0);
    }

    /**
     * 关闭电视
     */
    public void close(){
        closeTvCommand.excute(0);
    }

    /**
     * 换频道
     */
    public void change(){
        priorChannel = nowChannel;
        nowChannel++;
        changeChannelCommand.excute(nowChannel);
    }

    /**
     * 频道返回
     */
    public void ChannelUndo(){
        // 将以前的频道返回
        changeChannelCommand.excute(priorChannel);
        // 当前频道与前一个频道进行互换
        int tempChannel;
        tempChannel = priorChannel;
        priorChannel = nowChannel;
        nowChannel = tempChannel;
    }

}
