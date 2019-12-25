package com.joah.everyday.N201911.N20191121.iterator;

import java.util.Iterator;

public class FilmMenu implements TelevisionMenu {

    static final int MAX_ITEMS = 5;

    MenuItem[] menuItems;

    int numberOfItems = 0;

    public FilmMenu(){
        menuItems = new MenuItem[MAX_ITEMS];

        addItem(1,"达芬奇密码","这是一个简介，具体是啥我也不知1234567");
        addItem(2,"肖生克救赎","这是一个简介，具体是啥我也不知qwertyuio");
        addItem(3,"黑客帝国1","这是一个简介，具体是啥我也不知asdfghjkl");
        addItem(4,"三大傻","这是一个简介，具体是啥我也不知zxcvbnm,1qwsdfvbgt56yujkl.");
        addItem(5,"笑傲江湖","这是一个简介，具体是啥我也不知1qaz2wsx3edc4rfv");
    }

    /**
     * 将电影 添加到菜单项中
     * @param channe
     * @param name
     * @param description
     */
    @Override
    public void addItem(int channe, String name, String description) {
        MenuItem tvMenuItem = new MenuItem(channe, name, description);
        // 判断数组是否越界
        if (numberOfItems > MAX_ITEMS){
            System.out.println("不好意思，菜单满了...");
        }else {
            menuItems[numberOfItems] = tvMenuItem;
            numberOfItems++;
        }
    }

    @Override
    public Iterator createIterator() {

        Iterator iterator = new FilmMenuIterator(menuItems);

        return iterator;
    }
}
