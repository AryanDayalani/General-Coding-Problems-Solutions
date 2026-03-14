package STEP;

import java.util.*;

public class DigitsSum {

    public static int sumOfDigits(int number) {
        if (number < 0) {
            System.out.println("This is an error! Please enter a non-negative integer next time.");
            return -1;
        }
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a non-negative integer: ");
        int number = sc.nextInt();
        int sum = sumOfDigits(number);
        System.out.println("The sum of its digits are: " + sum);
        sc.close();
    }
}
