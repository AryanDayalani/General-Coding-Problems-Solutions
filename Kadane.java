// Kadane's Algorithm to find the maximum subarray sum

public class Kadane {
    public static int kadaneAlgorithm(int[] nums) {
        int maximum_sum = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int index = 0; index < nums.length; index++) {

            // step 1: Add the current element to the current sum

            current_sum += nums[index];

            // step 2: Update the maximum sum if current sum is greater
            if (current_sum > maximum_sum) {

                maximum_sum = current_sum;

                // step 3: If current sum becomes negative, reset it to 0
            } else if (current_sum < 0) {
                current_sum = 0;
            }
        }
        return maximum_sum;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = kadaneAlgorithm(arr);
        System.out.println("Maximum subarray sum: " + result);
    }
}