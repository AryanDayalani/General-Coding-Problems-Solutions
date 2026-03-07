import java.util.*;

class EvenFinder {
    public ArrayList<Integer> findEven(ArrayList<Integer> numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (!numbers.isEmpty()) {
            for (int number : numbers) {
                if (number%2 == 0) {
                    answer.add(number);
                }
            }
        } else {
            return new ArrayList<>();
        }
        return answer;
    }
}

public class FilterEvenNumbers {
    public static void main (String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(8);
        numbers.add(-6);
        EvenFinder ef = new EvenFinder();
        ArrayList<Integer> answer = ef.findEven(numbers);
        for (int number : answer) {
            System.out.print(number + " ");
        }
    }
}