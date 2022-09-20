
public class Main {

    public static void main(String[] args){
        ArrayList datos = new ArrayList();

        datos.addAtTail("uno");
        datos.addAtTail("dos");

        datos.addAtFront("3");
        datos.addAtFront("2");

        ArrayListIterator iterator = datos.getIterator();

        while(iterator.hasNext()){
            String value = iterator.next();

            System.out.println(value);
        }
    }
}
