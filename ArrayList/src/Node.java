
public class Node {
    private Node next;
    private String data;

    public Node(String data){
        this.data = data;
    }

    public void setNext(Node next){
        this.next=next;
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
}
