// 2nd December 2025 - Java program to find the maximum profit from stock prices

class ProfitCalculator {
    public int maximumProfit(int[] prices) {
        int buy_day = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[buy_day]) {
                buy_day = i;
            }
        }
        int sell_day = buy_day;
        for (int i = buy_day; i < prices.length; i++) {
            if (i > buy_day && prices[i] > prices[sell_day]) {
                sell_day = i;
            }

        }
        return (prices[sell_day] - prices[buy_day] > 0) ? (prices[sell_day] - prices[buy_day]) : 0;
    }
}

public class RA2311003010836 {
    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 1, 4 };
        ProfitCalculator pc = new ProfitCalculator();
        System.out.println("Maximum Profit: " + pc.maximumProfit(prices));
        ProfitCalculatorOptimal pco = new ProfitCalculatorOptimal();
        System.out.println("Maximum Profit (Optimal): " + pco.maximumProfit(prices));
    }
}

/*
 * The old code finds the global minimum price first and then looks for a sell
 * after it,
 * which fails if the best profit happens before the global minimum. The new
 * code updates
 * the minimum price dynamically while scanning, ensuring ALL buy–sell pairs
 * are considered and the true maximum profit is captured.
 */

// Updated optimal solution using dynamic minimum tracking
class ProfitCalculatorOptimal {
    public int maximumProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Track the lowest price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Check potential profit if sold today
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}
