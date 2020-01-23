package com.joah.everyday.N2019.N201911.N20191121.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TVChanneMenu implements TelevisionMenu{

    List<MenuItem> menuItems;

    public TVChanneMenu(){
        menuItems = new ArrayList<>();
        addItem(1,"cctv-1","This is CCTV-1");
        addItem(2,"cctv-2","This is CCTV-2");
        addItem(3,"cctv-3","This is CCTV-3");
        addItem(4,"cctv-4","This is CCTV-4");
        addItem(5,"cctv-5","This is CCTV-5");
        addItem(6,"cctv-6","This is CCTV-6");
        addItem(7,"cctv-7","This is CCTV-7");
    }

    /**
     * 将电视节目添加到菜单集合中
     * @param channe
     * @param name
     * @param description
     */
    @Override
    public void addItem(int channe, String name, String description) {
        MenuItem tvMenuItem = new MenuItem(channe, name, description);
        menuItems.add(tvMenuItem);
    }

    @Override
    public Iterator createIterator() {

        Iterator iterator = new TVChanneMenuIterator(menuItems);

        return iterator;
    }
}
