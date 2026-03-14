package STEP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzBuzz {

    public static List<String> fizzBuzzer(int number) {
        if (number < 0) {
            System.out.println("This is an error! Please enter an integer >=1 next time.");
            return new ArrayList<String>();
        }
        List<String> fb_list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fb_list.add("Fizz");
                continue;
            }
            if (i % 5 == 0 && i % 3 != 0) {
                fb_list.add("Buzz");
                continue;
            }
            if (i % 3 == 0 && i % 5 == 0) {
                fb_list.add("FizzBuzz");
                continue;
            } else {
                fb_list.add(String.valueOf(i));
            }
        }
        return fb_list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a non-negative (>=1) integer: ");
        int number = sc.nextInt();
        List<String> fb_list = fizzBuzzer(number);
        System.out.println("The list is: " + fb_list);
        sc.close();
    }
}
