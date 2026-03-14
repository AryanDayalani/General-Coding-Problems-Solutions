package STEP;

import java.util.*;

public class MissingNumber {
    public static int maximum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static int range_sum(int range) {
        int sum = 0;
        for (int i = 1; i <= range; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers (space separated): ");
        String input = sc.nextLine();
        String[] parts = input.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        int range = nums.length + 1;
        int arraySum = sum(nums);
        int expectedSum = range_sum(range);
        int missing_number = expectedSum - arraySum;
        System.out.println("The missing number is: " + missing_number);
        sc.close();
    }
}
