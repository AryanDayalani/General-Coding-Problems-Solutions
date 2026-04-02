package STEP;

import java.util.*;

public class LongestSubarrayEqual01 {
    public static int findMaxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Result: " + findMaxLength(arr));
        sc.close();
    }
}
