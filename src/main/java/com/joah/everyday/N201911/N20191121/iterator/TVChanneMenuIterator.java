package com.joah.everyday.N201911.N20191121.iterator;

import java.util.List;

public class TVChanneMenuIterator implements Iterator, java.util.Iterator {

    List<MenuItem> menuItems;

    int position = 0;

    public TVChanneMenuIterator(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position > menuItems.size() - 1 || menuItems.get(position) == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {

        MenuItem menuItem = menuItems.get(position);
        position++;

        return menuItem;
    }

    @Override
    public void remove() {

    }
}
