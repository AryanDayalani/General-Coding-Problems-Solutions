package STEP;

import java.util.*;

public class MinimumCostSteps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers (space separated): ");
        String input = sc.nextLine();
        String[] parts = input.split("\\s+");
        int[] cost = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            cost[i] = Integer.parseInt(parts[i]);
        }

        int minimum_cost = findMin(cost);
        System.out.println("Minimum cost: " + minimum_cost);
        sc.close();
    }

    public static int findMin(int[] cost) {
        int n = cost.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return cost[0];
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
