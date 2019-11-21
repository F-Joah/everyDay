package com.joah.everyday.N20191121.commands;

public class Client {

    public static void main(String[] args) {

        Command openCommand, closeCommand, changCommand;

        openCommand = new OpenTvCommand();

        closeCommand = new CloseTvCommand();

        changCommand = new ChangeChannelCommand();

        Controller controller = new Controller(openCommand,closeCommand,changCommand);

        controller.open();
        controller.change();
        controller.change();
        controller.ChannelUndo();
        controller.ChannelUndo();
        controller.ChannelUndo();
        controller.close();
    }
}
