package N201911.N20191121.iterator;

import java.util.Iterator;

public interface TelevisionMenu {

    void addItem(int channe, String name, String description);

    Iterator createIterator();
}
