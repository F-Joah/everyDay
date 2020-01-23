package com.joah.everyday.N2019.N201911.N20191126.Memento;

public class Client {

    public static void main(String[] args) {
        /**
         * 打boos之前，都是满格的
         */
        Role role = new Role(100,100);
        System.out.println("打boos之前");
        role.display();

        /**
         * 保持进度
         */
        Caretaker caretaker = new Caretaker();
        caretaker.memento = role.saveMemento();

        /**
         * 大战Boss,快Game Over了
         */
        role.setBloodFlow(20);
        role.setMagicPoint(20);
        System.out.println("打完Boos");
        role.display();

        /**
         * 恢复存档
         */
        role.restoreMemento(caretaker.getMemento());
        System.out.println("恢复");
        role.display();
    }
}
