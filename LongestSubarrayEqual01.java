public class LongestSubarrayEqual01 {
    public static int findMaxLength(int[] arr) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int zeros = 0;
            int ones = 0;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0)
                    zeros++;
                else
                    ones++;

                if (zeros == ones)
                    maxLen = Math.max(maxLen, j - i + 1);
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
