package uaslp.objetos.list;

import uaslp.objetos.list.Iterator;

public interface List<T> {

    void addAtTail (T data);
    void addAtFront(T data);
    boolean remove(int index);
    void removeAll();
    boolean setAt(int index, T data);
    T getAt(int index);
    void removeAllWithValue(T data);
    int getSize();
    Iterator<T> getIterator();
}
