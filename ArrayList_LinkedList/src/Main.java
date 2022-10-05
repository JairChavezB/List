import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayListIterator;
import uaslp.objetos.list.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args){
        List lista1 = new ArrayList();
        List lista2 = new LinkedList();

        lista1.addAtTail("5");
        lista1.addAtTail("1");

        lista1.addAtFront("3");
        lista1.addAtFront("2");

        lista1.removeAllWithValue("2");
        lista1.remove(2);
        lista1.setAt(1,"10");

        Iterator iterator = lista1.getIterator();

        while(iterator.hasNext()){
            String value = iterator.next();

            System.out.println(value);
        }
    }
}
