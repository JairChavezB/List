//package opp.collections.list.linkedList;
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addAtTail(String data) {
        Node node = new Node();

        node.setPrevious(tail);
        tail = node;

        if (head == null) {
            head = node;
        } else {
            node.getPrevious().setNext(node);
        }
        size++;
    }

    public void addAtFront(String data) {
        if(head == null){
            head = new Node();
        } else {
            Node node = new Node();
            node.setNext(head);
            head = node;
            size++;
        }

    }

    public boolean remove(int indexToRemove){
        if(indexToRemove <0 || indexToRemove > size){
            return false;
        }

        if(size == 1){
            head = null;
            tail = null;
        }else if(indexToRemove == 0){
            head = head.getNext();
            head.setPrevious(null);
        }else if (indexToRemove == size-1){
            tail = tail.getPrevious();
            tail.setNext(null);
        }else{
            Node iteratorNode = head ;
            findNodeByIndex(indexToRemove);

            iteratorNode.getPrevious().setNext(iteratorNode.getNext());
            iteratorNode.getNext().setPrevious(iteratorNode.getPrevious());
        }

        size--;
        return true;
    }


    public boolean removeAll(){

        Node iteratorNode = head;
        int indexIteratorNode =0;

        if(head == null) {
            return true;
        }
        if(size == 1){
            head = null;
            tail = null;
        }
        while(indexIteratorNode < size){
            head = head.getNext();
            head.setPrevious(null);
            iteratorNode = iteratorNode.getNext();
            indexIteratorNode++;
        }

        return true;
    }

    public boolean removeAllWithValue(String data){
        Node iteratorNode = head;

        if(head == null) {
            return true;
        }
        while(iteratorNode.getData() == data){
            head = head.getNext();
            head.setPrevious(null);
            size--;
        }
        iteratorNode = iteratorNode.getNext();
        return true;
    }

    public boolean setAt(int index, String data){
        if(index < 0 || index >= size){
            return false;
        }

        Node node = findNodeByIndex(index);
        node.setData(data);

        return true;
    }

    public String getAt(int index){
        if(index < 0 || index >= size){
            return null;
        }
        Node node = findNodeByIndex(index);

        return node.getData();
    }

    private Node findNodeByIndex(int index){
        Node iteratorNode = head;
        int indexIteratorNode = 0;

        while(indexIteratorNode < index){
            iteratorNode = iteratorNode.getNext();
            indexIteratorNode++;
        }

        return iteratorNode;
    }

    public int getSize(){
        return size;
    }

    public int getIterator(){
        return 1;
    }
}
