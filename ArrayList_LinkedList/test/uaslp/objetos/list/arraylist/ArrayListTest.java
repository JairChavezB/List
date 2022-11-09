package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class ArrayListTest {

    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given
        ArrayList<String> list= new ArrayList<>();

        //When
        int size = list.getSize();

        //Then
        Assertions.assertEquals(0, size);
    }


    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne() throws NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();

        //When
        Assertions.assertThrows(NullNotAllowedException.class,() -> list.addAtTail(null));

        //Then
        Assertions.assertEquals(0, list.getSize());
    }


    @Test
    public void givenAnEmptyList_whenAddAtTail_thenSizeIsIncreased() throws NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
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
        ArrayList<String> list = new ArrayList<>();

        //When
        Assertions.assertThrows(NullNotAllowedException.class,() -> list.addAtFront(null));

        //Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased() throws NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(NullNotAllowedException.class,() -> list.addAtFront(null));

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenAList_whenRemoveLeesThanZero_thenReturnFalse() throws NullNotAllowedException, WrongIndexException {
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Uno");

        //When
        try{
            list.remove(-1);
        }catch(WrongIndexException | NullNotAllowedException ex){
            System.out.println("Exception Thrown");
        }
        //Then
    }

    @Test
    public void givenAList_whenRemoveLeesThanSize_thenReturnFalse() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.remove(-1));
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class, () -> list.remove(1));

        //Then
    }

    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue() throws WrongIndexException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.remove(-2));

        //Then
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    public void givenAListWithOneElement_whenRemoveTail_thenReturnTrue() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtTail("Dos");

        //When
        Assertions.assertThrows(WrongIndexException.class,() ->list.remove(2));

        //Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(list.getAt(0), "Uno");
        Assertions.assertEquals(list.getAt(1), "Dos");
    }

    @Test
    public void givenAListWith3Element_whenRemoveTail_thenReturnTrue() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtTail("Dos");

        //When
        Assertions.assertThrows(WrongIndexException.class,() ->list.remove(2));

        //Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(list.getAt(0), "Uno");
        Assertions.assertEquals(list.getAt(1), "Dos");
    }

    @Test
    public void givenAListWith3Element_whenRemoveAll_thenSizeIsZero(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        list.removeAll();

        //Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWith3Element_whenSetAt1_thenElementIsModified() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.setAt(3,"Cuatro"));
    }

    @Test
    public void givenAListWith3Element_whenSetAtLessThan0_thenReturnNull() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class, () -> list.setAt(-1, "Cuatro"));

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }

    @Test
    public void givenAListWith3Element_whenSetAtIndex3_thenReturnNull() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class, () -> list.setAt(3,"Cuatro"));

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }

    @Test
    public void givenAListWithNElement_removeAllWithAValue() throws NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");
        //Dos Uno Tres

        //When
        Assertions.assertThrows(NullNotAllowedException.class,() -> list.removeAllWithValue(null));

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }

    @Test
    public void givenAList_whenGetAtLessThan0_thenReturnNull() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.getAt(-1));

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenAList_whenGetAtIndexGreaterThanSize_thenReturnNull() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Dos");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.getAt(1));

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
    }


    @Test
    public void givenAList_whenSetAt1_thenElementIsFound() throws WrongIndexException, NullNotAllowedException{
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        Assertions.assertThrows(WrongIndexException.class,() -> list.getAt(3));

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }
}
