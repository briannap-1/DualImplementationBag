import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Brianna Penkala
 * This is the test class for DualImplementationBag. Tests are divided based on data type with ArrayList tests before LinkedList tests.
 */
class DualImplementationBagTest {

    /** These are the fields for bags that will be tested throughout the class*/
    private DualImplementationBag<String> bag;
    private DualImplementationBag<String> bag2;
    private DualImplementationBag<Integer> emptyBagArray;
    private DualImplementationBag<Integer> emptyBagLinked;
    private DualImplementationBag<Integer> bag3;
    private DualImplementationBag<Integer> bag4;

    /*This method sets up bags to be tested throughout the testing methods*/
    @BeforeEach
    public void setUp() {
        //initializing arrayList
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        //creating bag
        bag = new DualImplementationBag<String>(true);
        //adding arrayList elements to bag
        for (String element : arrayList) {
            bag.add(element);
        }

        //initializing arrayList2
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("A");
        arrayList2.add("A");
        arrayList2.add("A");
        //creating bag2
        bag2 = new DualImplementationBag<String>(true);
        //adding arrayList2 elements to bag2
        for (String element : arrayList2) {
            bag2.add(element);
        }

        //initializing linkedList
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        //creating bag3
        bag3 = new DualImplementationBag<>(false);
        //adding linkedList elements to bag3
        for (Integer element : linkedList) {
            bag3.add(element);
        }

        //initializing linkedList2
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        linkedList2.add(0);
        linkedList2.add(9);
        linkedList2.add(8);
        //creating bag4
        bag4 = new DualImplementationBag<Integer>(false);
        //adding linkedList2 elements to bag4
        for (Integer element : linkedList2) {
            bag4.add(element);
        }

        //creating empty bags of both types
        emptyBagArray = new DualImplementationBag<>(true);
        emptyBagLinked = new DualImplementationBag<>(false);
    }

    /** This test shows that the bag can be switched from an ArrayList to a LinkedList, or vice-versa*/
    @Test
    void setUseArrayList() {
        bag.setUseArrayList(false);
        assertEquals(3, bag.size());
        bag.setUseArrayList(true);
        assertEquals(3, bag.size());
    }

    /** This test checks getUseArray() when true and false*/
    @Test
    void getUseArrayList() {
        assertTrue(bag.getUseArrayList());

        assertFalse(bag3.getUseArrayList());
    }

    /** This test checks add() for both data types with size() used for proof of addition*/
    @Test
    void add() {
        assertEquals(3, bag.size());
        assertTrue(bag.add("D"));
        assertEquals(4, bag.size());
        assertTrue(bag.add(""));

        assertEquals(4, bag3.size());
        assertTrue(bag3.add(5));
        assertEquals(5, bag3.size());
    }

    /** This test checks remove() for both data types with size() used for proof of addition. The case of nonexistent elements is also tested*/
    @Test
    void remove() {
        assertEquals(3, bag.size());
        assertTrue(bag.remove("A"));
        assertEquals(2, bag.size());
        assertFalse(bag.remove(""));
        assertFalse(bag.remove("AAAAAA"));

        assertEquals(4, bag3.size());
        assertTrue(bag3.remove(3));
        assertEquals(3, bag3.size());
        assertFalse(bag3.remove(9));
    }

    /** This test checks contains() for both data types with existent and non-existent elements*/
    @Test
    void contains() {
        assertTrue(bag.contains("A"));
        assertFalse(bag.contains("Z"));
        assertFalse(bag.contains(""));

        assertTrue(bag3.contains(1));
        assertFalse(bag3.contains(8));
    }

    /** This test checks isEmpty() for both data types when true and false*/
    @Test
    void isEmpty() {
        assertFalse(bag.isEmpty());
        assertTrue(emptyBagArray.isEmpty());

        assertFalse(bag3.isEmpty());
        assertTrue(emptyBagLinked.isEmpty());
    }

    /** This test checks size() for both types with used and empty bags*/
    @Test
    void size() {
        assertEquals(3, bag.size());
        assertEquals(0, emptyBagArray.size());

        assertEquals(4, bag3.size());
        assertEquals(0, emptyBagLinked.size());
    }

    /** This test checks getFrequencyOf() for both data types with 0, 1, and many element occurrences. I did not see how this would be useful in DemoBag*/
    @Test
    void getFrequencyOf() {
        bag.add("A");
        assertEquals(2, bag.getFrequencyOf("A"));
        assertEquals(1, bag.getFrequencyOf("B"));
        assertEquals(0, bag.getFrequencyOf("Z"));

        bag3.add(1);
        assertEquals(3, bag3.getFrequencyOf(1));
        assertEquals(1,bag3.getFrequencyOf(4));
        assertEquals(0, bag3.getFrequencyOf(8));
    }

    /** This test checks get() for both data types at the beginning, middle, and end of the bags*/
    @Test
    void get() {
        assertEquals("A", bag.get(0));
        assertEquals("B", bag.get(1));
        assertEquals("C", bag.get(2));

        assertEquals(1, bag3.get(0));
        assertEquals(3, bag3.get(2));
        assertEquals(4, bag3.get(3));
    }
}