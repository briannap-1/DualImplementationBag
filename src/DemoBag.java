import java.util.NoSuchElementException;

/**
 * @author Brianna Penkala
 * This class demonstrates the use of DualImplementationBag
 */

public class DemoBag {

    /** A method that removes all occurrences of an element from the bag
     * @param element the element to remove from the bag
     */
    public <T> void removeAll (DualImplementationBag<T> bag, T element) {
        if (!bag.isEmpty()) {
            for (int index = bag.size() - 1; index >= 0; index--) {
                if (bag.get(index).equals(element))
                    bag.remove(bag.get(index));
            }
        }
        else throw new NoSuchElementException();
    }

    /** A method that retains all occurrences of an element that is exactly the same as the specified element
     * @param element the element to retain
     */
    public <T> void retainAll (DualImplementationBag<T> bag, T element) {
        if (!bag.isEmpty()) {
            for (int index = bag.size() - 1; index >= 0; index--) {
                if (!(bag.get(index).equals(element)))
                    bag.remove(bag.get(index));
            }
        }
        else throw new NoSuchElementException();
    }

    /** A method that combines the existing bag with the new bag
     * @param otherBag1 the bag that will have elements added
     * @param otherBag2 the bag that will be added to otherBag1
     * @return a new bag with the combined elements
     */
    public <T> DualImplementationBag<T> union (DualImplementationBag<T> otherBag1, DualImplementationBag<T> otherBag2) {
        boolean type = otherBag1.getUseArrayList(); //used to determine newBag's type
        DualImplementationBag<T> newBag = new DualImplementationBag<T> (type); //creation of newBag with the matching type
        for (int index1 = 0, index2 = 0; index1 < otherBag1.size() || index2 < otherBag2.size(); index1++, index2++) {
            if (index1 >= otherBag1.size())
                newBag.add(otherBag2.get(index2));
            if (index2 >= otherBag2.size())
                newBag.add(otherBag1.get(index1));
            else {
                newBag.add(otherBag1.get(index1));
                newBag.add(otherBag2.get(index2));
            }
        }
        return newBag;
    }

    /** A method that creates a new bag of shared elements
     * @param otherBag1 one bag to check for shared elements
     * @param otherBag2 the other bag to check for shared elements
     * @return a new bag with the shared elements
     */
    public <T> DualImplementationBag<T> intersection (DualImplementationBag<T> otherBag1, DualImplementationBag<T> otherBag2) {
        boolean type = otherBag1.getUseArrayList(); //used to determine newBag's type
        DualImplementationBag<T> newBag = new DualImplementationBag<T> (type); //creation of newBag with the matching type
        for (int index = 0; index < otherBag2.size(); index++) { //made limit otherBag2 size since there will not be similar elements after length is reached
            if (otherBag1.contains(otherBag2.get(index)))
                newBag.add(otherBag2.get(index));
        }
        return newBag;
    }

    /** A method that creates a bag with elements in this bag but not in the other
     * @param otherBag1 the bag with elements to compare to otherBag2
     * @param otherBag2 the comparison bag
     * @return a new bag with the elements only in otherBag1
     */
    public <T> DualImplementationBag<T> difference (DualImplementationBag<T> otherBag1, DualImplementationBag<T> otherBag2) {
        boolean type = otherBag1.getUseArrayList(); //used to determine newBag's type
        DualImplementationBag<T> newBag = new DualImplementationBag<T> (type); //creation of newBag with the matching type
        int index1 = 0;
        for (; index1 < otherBag1.size(); index1++) {
            T test = otherBag1.get(index1);
            if (!otherBag2.contains(test))
                newBag.add(test);
        }
        return newBag;
    }
}