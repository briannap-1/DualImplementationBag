import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Brianna Penkala
 * This class represents a Bag ADT that allows switching between two internal data structures: ArrayList and LinkedList
 */

public class DualImplementationBag<T> {

    /** A field indicating the use of an ArrayList or LinkedList */
    boolean useArrayList;
    /** A field that stores the bag elements */
    List<T> internalList;

    /** The constructor for the class which initializes useArrayList
     * @param useArrayList indicates whether the methods will use an ArrayList if true or LinkedList if false
     */
    public DualImplementationBag (boolean useArrayList) {
        this.useArrayList = useArrayList;
        if (useArrayList)
            internalList = new ArrayList<T>();
        else {
            internalList = new LinkedList<T>();
        }
    }

    /** A method that switches the internal data structure
     * @param useArrayList indicates whether the methods will use an ArrayList if true or LinkedList if false
     */
    public void setUseArrayList (boolean useArrayList) {
        this.useArrayList = useArrayList; //switches internal data structure
        if (useArrayList) {
            ArrayList<T> newInternalList = new ArrayList<T>();
            for (T element : internalList)
                newInternalList.add(element);
            internalList = newInternalList;
        }
        else {
            LinkedList<T> newInternalList = new LinkedList<T>();
            for (T element : internalList)
                newInternalList.add(element);
            internalList = newInternalList;
        }
    }

    /**
     * A method to determine what kind of list is used in a bag
     * @return true if the bag uses an ArrayList, false if it uses a LinkedList
     */
    public boolean getUseArrayList (){
        return useArrayList;
    }

    /** A method that adds an element to the bag
     * @param element the element to add to the bag
     * @return true if the element was successfully added
     */
    public boolean add (T element) {
        return internalList.add(element);
    }

    /** A method that removes an element from the bag
     * @param element the element to remove from the bag
     * @return true if the element was successfully removed
     */
    public boolean remove (T element) {
        if (internalList.isEmpty())
            throw new NoSuchElementException();
        else
            return internalList.remove(element);
    }

    /** A method that checks if an element is in the bag
     * @param element the element to look for
     * @return true if the bag contains the element
     */
    public boolean contains (T element) {
        boolean contains = false;
        for (T item : internalList) {
            if (item.equals(element)) {
                contains = true;
            }
        }
        return contains;
    }

    /** A method that checks if the bag is empty
     * @return true if the bag is empty, false otherwise
     * */
    public boolean isEmpty () {
        return (internalList.size() < 1);
    }

    /** A method that returns the number of elements in the bag
     * @return the size of the bag
     * */
    public int size () {
        int i = 0;
        for (T item : internalList) {
            i++;
        }
        return i;
    }

    /** A method that returns the number of occurrences of an element in the bag
     * @param element the element to count
     * @return the number of occurrences of the element
     * */
    public int getFrequencyOf (T element) {
        int frequency = 0;
        for (T item : internalList) {
            if (item.equals(element))
                frequency++;
        }
        return frequency;
    }

    /** A method to get the element of an index in a bag
     * @param index the index of the element being searched for
     * @return the element at the index
     */
    public T get (int index) {
        if (index > internalList.size())
            throw new NoSuchElementException();
        else
            return internalList.get(index);
    }
}
