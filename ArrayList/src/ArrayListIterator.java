
public class ArrayListIterator {
        private ArrayList arrayList;
        private int currentIndex =0;

        public ArrayListIterator(ArrayList arrayList){
            this.arrayList = arrayList;
        }

        public boolean hasNext() {
            return currentIndex < arrayList.getSize();
        }

        public String next(){
            return arrayList.getAt(currentIndex++);
        }
}
