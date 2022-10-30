package uaslp.objetos.list;

import uaslp.objetos.list.Iterator;

public interface List {

    void addAtTail (String data);
    void addAtFront(String data);
    boolean remove(int index);
    void removeAll();
    boolean setAt(int index, String data);
    String getAt(int index);
    void removeAllWithValue(String data);
    int getSize();
    Iterator getIterator();
}
