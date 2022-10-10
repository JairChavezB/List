import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List; 
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayListIterator;
import uaslp.objetos.list.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args){
        List lista2 = new LinkedList();

        lista2.addAtTail("50");
        lista2.addAtTail("20");

        lista2.addAtFront("90");
        lista2.addAtFront("40");
        lista2.setAt(3,"10");
        //lista2.removeAll();

        Iterator iterator = lista2.getIterator();

        while(iterator.hasNext()){
            String value = iterator.next();

            System.out.println(value);
        }
    }
}
