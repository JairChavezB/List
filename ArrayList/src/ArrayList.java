
public class ArrayList<A>{
    private A[] array;
    private int size;

    public ArrayList(int size) {
        array = (A[])new Object[size];
    }

    public void addAtTail(A data) {

        if(data == null){
            return;
        }
        if(size == array.length) {
           size++;
        }
        array[size] = data;
    }

    public void addAtFront(A data) {
        if(data == null){
            return;
        }
        if(size == array.length){
            size++;
        }

        if(size >= 0){
            System.arraycopy(array, 0, array, 1 , size);
        }
        array[0] = data;
        size++;
    }

    public boolean remove(int indexToRemove){
        if(indexToRemove <0 || indexToRemove >= size){
            return false;
        }

        if(array.length > indexToRemove){

        }

        size--;
        return true;
    }


    public void removeAll(){
        for (int i=0; i<size; i++){
            array[i] = null;
        }
        size=0;
    }

    public void removeAllWithValue(String data){
        for(int i=0; i<size; i++){
            if(array[i] == data){
                array[i] = null;
            }
        }
    }

    public boolean setAt(int index, A data){
        if(index < 0 || index >= size){
            return false;
        }else{
            array[index] = data;
            return true;
        }
    }

    public boolean getAt(int index){
        if(index < 0 || index >= size){
            return false;
        }
        return true;
    }

    public int getSize(){
        return size;
    }

    public int getIterator(){
        return 1;
    }
}
