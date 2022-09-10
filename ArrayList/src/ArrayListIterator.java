public class ArrayListIterator<A>{
    private ArrayList<A> arrayList;
    private int arrayIterator;
    private boolean data;

    public ArrayListIterator(ArrayList<A> arrayList){
        this.arrayList= arrayList;
    }

    public boolean hasNext(){
        return arrayIterator < arrayList.getSize();
    }

    public boolean Next(){
        data = arrayList.getAt(arrayIterator);
        arrayIterator++;
        return data;
    }
}
