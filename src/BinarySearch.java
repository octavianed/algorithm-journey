public class BinarySearch {

    public BinarySearch() {
    }

    /**
     * This method is iterative algorithm to solve the problem.
     * Algorithmic complexity Θ(N)
     * @param array Ordered array.
     * @param element Element we are looking for inside the given array.
     * @return Returns true if element was found or false if it was not.
     */
    public boolean containsElementIterative(int[] array, int element) {
        boolean found = false, bigger = false;
        int i = 0;
        while(!found && !bigger && i<array.length) {
            if(array[i] == element)
                found = true;
            else if (array[i] >= element)
                bigger = true;
            i++;
        }
        return found;
    }

    /**
     * Auxiliar recursive method that implements Divide and Conquer algorithm.
     * Algorithmic complexity Θ(Log N)
     * @param array Ordered array.
     * @param i0 References the first element of a subarray from the original array.
     * @param iN References the last element of a subarray from the original array.
     * @param element Element we are looking for inside the given array.
     * @return Returns whether the element was found or not in the given subarray.
     */
    public boolean containsAux(int[] array, int i0, int iN, int element) {
        if(i0 == iN) //If the subarray has only one element
            return (element == array[i0]);
        else { //If the subarray has more than one element
            int k = (i0 + iN) / 2;  //i0 + (iN-i0) / 2 better
            if(element < array[k])
                return containsAux(array, i0, k, element);
            else if (element == array[k])
                return true;
            else
                return containsAux(array, k+1, iN, element);
        }
    }

    /**
     * Main method which calls aux method to use Divide and Conquer algorithm.
     * With i0=0 and iN = array.lenth-1 we are first looking for the element in all the original array.
     * This is the header we are asked for when solving this problem.
     * @param array
     * @param element
     * @return Returns whether the element was found or not in the given original array.
     */
    public boolean containsElement(int[] array, int element) {
        return containsAux(array, 0, array.length-1, element);
    }


    /**
     * Testing in main the BinarySearch algorithms.
     * @param args
     */
    public static void main(String[] args) {

        int[] array = {4, 6, 10, 15, 23, 41, 65, 71, 121};
        BinarySearch bs = new BinarySearch();

        if(bs.containsElement(array, 22))
            System.out.println("Element found.");
        else
            System.out.println("Element not found.");
    }





}
