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
            int suma = 0;
            for (int iN = i0; iN < array.length; iN++) {
                suma += array[iN];
                if (suma > max) {
                    max = suma;
                    i0Max = i0;
                    iNMax = iN;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {

        int[] array = {-2, 12, 3, 4, -21, 8, 12, 5, -6, 1};
        MaxSubarray ms = new MaxSubarray();
        ms.maxSubarrayBruteForce(array);
    }




}
