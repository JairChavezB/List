package uaslp.objetos.list.linkedlist;

public class Node {
     Node next;
     Node previous;
     String data;

     public Node(String data){
         this.data = data;
     }
    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    //LinkedList
    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

}
