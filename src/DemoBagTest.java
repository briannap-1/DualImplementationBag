import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Brianna Penkala
 * This is the test class for DemoBag. Tests are divided based on data type with ArrayList tests before LinkedList tests.
 */
class DemoBagTest {

    /** These are the fields for bags that will be tested throughout the class*/
    private DualImplementationBag<String> bag;
    private DualImplementationBag<String> bag2;
    private DualImplementationBag<Integer> bag3;
    private DualImplementationBag<Integer> bag4;
    private final DemoBag demoBag = new DemoBag();
    private DualImplementationBag<String> emptyBagArray;
    private DualImplementationBag<Integer> emptyBagLinked;

    /*This method sets up bags to be tested throughout the testing methods*/
    @BeforeEach
    public void setUp() {
        //initializing arrayList
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");
        //creating bag
        bag = new DualImplementationBag<>(true);
        //adding arrayList elements to bag
        for (String element : arrayList) {
            bag.add(element);
        }

        //initializing arrayList2
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("a");
        arrayList2.add("b");
        arrayList2.add("c");
        //creating bag2
        bag2 = new DualImplementationBag<>(true);
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
        //adding linkedList elements to the bag3
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
        //adding linkedList2 elements to the bag4
        for (Integer element : linkedList2) {
            bag4.add(element);
        }

        //creating empty bags of both types
        emptyBagArray = new DualImplementationBag<>(true);
        emptyBagLinked = new DualImplementationBag<>(false);
    }

    /** This test checks removeAll() with both types using size() and getFrequencyOf() for proof*/
    @Test
    void removeAll() {
        assertEquals(4, bag.size());
        demoBag.removeAll(bag, "A");
        assertEquals(2, bag.size());
        assertEquals(0, bag.getFrequencyOf("A"));

        assertEquals(4, bag3.size());
        demoBag.removeAll(bag3, 1);
        assertEquals(2, bag3.size());
        assertEquals(0, bag3.getFrequencyOf(1));
    }
    /** This test checks retainAll() with both types using size() and getFrequencyOf() for proof*/
    @Test
    void retainAll() {
        bag.add("B");
        demoBag.retainAll(bag,"B");
        assertEquals(2, bag.getFrequencyOf("B"));
        assertEquals(2, bag.size());

        bag3.add(1);
        demoBag.retainAll(bag3,1);
        assertEquals(3, bag3.getFrequencyOf(1));
        assertEquals(3, bag3.size());
    }

    /** This test checks union() with both types using full and empty bags*/
    @Test
    void union() {
        assertEquals(7, demoBag.union(bag, bag2).size());
        assertEquals(4, demoBag.union(bag, emptyBagArray).size());

        assertEquals(7, demoBag.union(bag3, bag4).size());
        assertEquals(4, demoBag.union(bag3, emptyBagLinked).size());
    }

    /** This test checks intersection() with both types using 0, 1, and many identical elements*/
    @Test
    void intersection() {
        assertEquals(0, demoBag.intersection(bag, bag2).size());
        bag2.add("A");
        assertEquals(1, demoBag.intersection(bag, bag2).size());
        bag2.add("B");
        bag2.add("C");
        assertEquals(3, demoBag.intersection(bag, bag2).size());

        assertEquals(0, demoBag.intersection(bag3, bag4).size());
        bag4.add(3);
        assertEquals(1, demoBag.intersection(bag3, bag4).size());
        bag4.add(4);
        bag4.add(1);
        assertEquals(3, demoBag.intersection(bag3, bag4).size());
    }

    /** This test checks difference() with both types using 0, 1, and many identical elements*/
    @Test
    void difference() {
        assertEquals(4, demoBag.difference(bag, bag2).size());
        bag2.add("A");
        assertEquals(2, demoBag.difference(bag, bag2).size());
        bag2.add("B");
        assertEquals(1, demoBag.difference(bag, bag2).size());

        assertEquals(4, (demoBag.difference(bag3, bag4)).size());
        bag4.add(3);
        assertEquals(3, (demoBag.difference(bag3, bag4)).size());
        bag4.add(4);
        assertEquals(2, (demoBag.difference(bag3, bag4)).size());
    }
}