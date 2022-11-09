package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

import uaslp.objetos.list.Iterator;

public interface List<T> {

    void addAtTail (T data) throws NullNotAllowedException;
    void addAtFront(T data) throws NullNotAllowedException;
    boolean remove(int index) throws WrongIndexException;
    void removeAll();
    boolean setAt(int index, T data) throws WrongIndexException, NullNotAllowedException;
    T getAt(int index) throws WrongIndexException;
    void removeAllWithValue(T data);
    int getSize();
    Iterator<T> getIterator();
}
