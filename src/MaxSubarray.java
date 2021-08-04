public class MaxSubarray {

    /**
     * Problem: find the maximum sum of the numbers of any subarray inside the given array.
     * We will solve it using two different type of algorithms:
     * - Brute force --> Algorithmic complexity Θ(N^2)
     * - Divide and Conquer --> Algorithmic complexity Θ(N*logN)
     */
    public MaxSubarray() {

    }


    /**
     * This solution consists in finding all possible subarrays and their sum.
     * We use variables to store the highest value of a subarray and the positions of where it starts and ends.
     * Algorithmic complexity Θ(N^2)
     * @param array Given array (not necessarily ordered)
     * @return Returns the maximum sum of the numbers of a subarray.
     */
    public int maxSubarrayBruteForce(int[] array) {
        int max = Integer.MIN_VALUE, i0Max = 0, iNMax = 0;
        for (int i0 = 0; i0 < array.length; i0++) {
            int sum = 0;
            for (int iN = i0; iN < array.length; iN++) {
                sum += array[iN];
                if (sum > max) {
                    max = sum;
                    i0Max = i0;
                    iNMax = iN;
                }
            }
        }
        /*System.out.println("Highest subarray goes between " + i0Max + " and " +
                iNMax + " array positions.");*/
        return max;
    }

    ///// Recursive solution

    /**
     * Case 1: The maximum subarray belongs to one of the subarrays.
     * Case 2: The maximum subarray is found in the division between both subarrays, and contains the element we divided by.
     * Steps: Divide the array by half, call recursively to find the maximum subarray from each half (m1 and m2),
     *  when combining we need to look for a maximum subarray (m3) that contains the element by which we divided.
     *  After that we compare m1, m2 and m3, and return the biggest one.
     * @param array Given array (not necessarily ordered)
     * @return Returns biggest subarray from the original array.
     */
    public int maxSubArray(int[] array) {
        return maxSubArrayAux(array, 0, array.length-1);
    }


    /**
     * Auxiliar recursive method that implements Divide and Conquer algorithm.
     * Algorithmic complexity Θ(N*logN)
     * @param array Given array (not necessarily ordered)
     * @param i0 Starting position of the array.
     * @param iN Ending position of the array.
     * @return Returns biggest subarray from the original array.
     */
    public int maxSubArrayAux(int[] array, int i0, int iN) {
        if(i0 == iN)
            return array[i0];
        else {
            int k = (i0 + iN) / 2; //i0 - (iN - i0)/2 better
            int m1 = maxSubArrayAux(array, i0, k);
            int m2 = maxSubArrayAux(array, k+1, iN);
            int m3 = maxSubArrayContainingDivisionElement(array, i0, k, iN);
            return Math.max(m1, Math.max(m2, m3));
        }
    }

    /**
     * Obtains the maximum subarray (m3) that contains the element by which we divided.
     * @param array Given array (not necessarily ordered)
     * @param i0 Starting position of the subarray.
     * @param k Element by which the array was divided.
     * @param iN Ending position of the subarray.
     * @return Returns the largest subarray that contains the element by which we divided (k), and goes between iMax and jMax positions of the original array.
     */
    public int maxSubArrayContainingDivisionElement(int[] array, int i0, int k, int iN) {
        int max = Integer.MIN_VALUE, sum = 0, iMax = k, jMax = k;
        //we search from left of k, the biggest subarray from i to k
        for(int i = k; i >= i0; i--) {
            sum += array[i];
            if(sum > max) {
                max = sum;
                iMax = i;
            }
        }
        sum = max;
        //we search from right of k (k+1) the biggest subarray from i to j
        for(int j = k+1; j <= iN; j++) {
            sum += array[j];
            if(sum > max) {
                max = sum;
                jMax = j;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        int[] array = {-2, 12, 3, 4, -21, 8, 12, 5, -6, 1};
        MaxSubarray ms = new MaxSubarray();

        //Testing iterative algorithm
        System.out.println(ms.maxSubarrayBruteForce(array));


        //Testing recursive Divide and Conquer algorithm
        System.out.println(ms.maxSubArray(array));

    }
    

}
