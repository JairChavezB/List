package uaslp.objetos.list.linkedlist;


import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // uaslp.objetos.list.linkedlist.LinkedList.Node

    private static class Node<S> { //Sin palabra de modificador de acceso es package-private
        Node<S> next;
        Node<S> previous;
        S data;

        public Node(S data) {
            this.data = data;
        }
    }

    public class LinkedListIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedListIterator() {
            this.current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.data;

            current = current.next;

            return data;
        }
    }


    public void addAtTail(T data) throws NullNotAllowedException{
        if( data == null){
            throw new NullNotAllowedException();
        }
        Node<T> node = new Node<>(data);

        node.previous = tail;
        tail = node;

        if (head == null) {
            head = node;
        } else {
            node.previous.next = node;
        }

        size++;
    }

    public void addAtFront(T data) throws NullNotAllowedException{
        if(data == null){
            throw new NullNotAllowedException();
        }
        Node<T> node = new Node<>(data);

        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        } else {
            node.next.previous = node;
        }

        size++;
    }

    public boolean remove(int indexToRemove) throws WrongIndexException{

        if (indexToRemove < 0 || indexToRemove >= size) {
            throw new WrongIndexException();
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (indexToRemove == 0) {
            head = head.next;
            head.previous = null;
        } else if (indexToRemove == size - 1) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node<T> iteratorNode = findNodeByIndex(indexToRemove);

            iteratorNode.previous.next = iteratorNode.next;
            iteratorNode.next.previous = iteratorNode.previous;
        }

        size--;

        return true;
    }

    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean setAt(int index, T data) throws WrongIndexException, NullNotAllowedException{
        if (index < 0 || index >= size) {
            throw new WrongIndexException();
        }
        if(data == null){
            throw new NullNotAllowedException();
        }

        Node<T> node = findNodeByIndex(index);

        node.data = data;

        return true;
    }

    public T getAt(int index) throws WrongIndexException{
        if (index < 0 || index >= size) {
            throw new WrongIndexException();
        }

        Node<T> node = findNodeByIndex(index);

        return node.data;
    }

    public void removeAllWithValue(T value) throws NullNotAllowedException {
        if(value == null){
            throw new NullNotAllowedException();
        }

        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(value)) {
                if (current == head) {
                    head = current.next;
                    if (head == null) {
                        tail = null;
                    } else {
                        head.previous = null;
                    }
                } else {
                    current.previous.next = current.next;
                    if (current == tail) {
                        tail = current.previous;
                    } else {
                        current.next.previous = current.previous;
                    }
                }
            }
            current = current.next;
        }

    }

    public int getSize() {
        return size;
    }

    public LinkedListIterator getIterator() {
        return new LinkedListIterator();
    }

    private Node<T> findNodeByIndex(int index) throws WrongIndexException{
        if (index < 0 || index >= size) {
            throw new WrongIndexException();
        }
        Node<T> iteratorNode = head;
        int indexIteratorNode = 0;

        while (indexIteratorNode < index) {
            iteratorNode = iteratorNode.next;
            indexIteratorNode++;
        }

        return iteratorNode;
    }

}
