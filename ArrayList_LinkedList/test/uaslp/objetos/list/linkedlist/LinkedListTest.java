package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class LinkedListTest {

    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given
        LinkedList<String> list= new LinkedList<>();

        //When
        int size = list.getSize();

        //Then
        Assertions.assertEquals(0, size);
    }


    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne() throws WrongIndexException, NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();

        //When
        Assertions.assertThrows(NullNotAllowedException.class,() -> list.addAtTail(null));

        //Then
        Assertions.assertEquals(0, list.getSize());
    }


    @Test
    public void givenAnEmptyList_whenAddAtTail_thenSizeIsIncreased() throws NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");

        //When
        Assertions.assertThrows(NullNotAllowedException.class,() -> list.addAtTail(null));

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne() throws NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();

        //When
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.addAtFront(null));

        //Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased() throws NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.addAtFront(null));

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenAList_whenRemoveLeesThanSize_thenReturnFalse() throws WrongIndexException, NullNotAllowedException {
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.remove(-1));
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse() throws WrongIndexException, NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.remove(2));
    }

    @Test
    public void givenAListWithOneElement_whenRemoveLess0_thenReturnTrue() throws WrongIndexException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class, () -> list.remove(-1));

        //Then
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    public void givenAListWithOneElement_whenRemoveGeaterSize_thenReturnTrue() throws WrongIndexException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class, () -> list.remove(3));

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(list.getAt(0), "Uno");
    }

    @Test
    public void givenAListWith3Element_whenRemoveAll_thenSizeIsZero(){
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        list.removeAll();

        //Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWith3Element_whenSetAtNull_thenElementIsModified() throws NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.setAt(2,null));

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }

    @Test
        public void givenAListWith3Element_whenSetAtLessThan0_thenReturnNull() throws WrongIndexException {
            //Given
        LinkedList<String> list = new LinkedList<>();
            list.addAtTail("Uno");
            list.addAtFront("Dos");
            list.addAtTail("Tres");

            //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.setAt(-1,"Cuatro"));
    }

    @Test
    public void givenAListWith3Element_whenSetAtIndex3_thenReturnNull() throws WrongIndexException, NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.setAt(3,"Cuatro"));
    }

    @Test
    public void givenAListWithNElement_removeAllWithAValue() throws NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");

        //When
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.removeAllWithValue(null));

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenAListWith3Element_whenGetAtLessThan0_thenReturnNull() throws WrongIndexException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.getAt(-1));
    }

    @Test
    public void givenAListWith3Element_whenGetAtIndex3_thenReturnNull() throws WrongIndexException, NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.getAt(3));
    }


    @Test
    public void givenAListWith3Element_whenSetAt1_thenElementIsFound() throws WrongIndexException,NullNotAllowedException{
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class, () -> list.setAt(-1,"Trece"));
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.setAt(2,null));

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }
}
