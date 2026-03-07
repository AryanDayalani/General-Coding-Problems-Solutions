import java.util.*;

class FibbonacciFinder {
    // iterative approach by summing numbers
    public ArrayList<Integer> findSeriesIterative(int number) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (number >= 0) {
            answer.add(0);
        }
        if (number >= 1) {
            answer.add(1);
        }
        int a = 0, b = 1;
        while (true) {
            int c = a + b;
            if (c > number)
                break;
            answer.add(c);
            a = b;
            b = c;
        }
        return answer;
    }

    public ArrayList<Integer> findSeriesRecursive(int number) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (number >= 0) {
            buildSeries(answer, 0, 1, number);
        }
        return answer;
    }

    private void buildSeries(ArrayList<Integer> list, int current, int next, int limit) {
        if (current > limit)
            return;
        list.add(current);
        buildSeries(list, next, current + next, limit);
    }
}

public class Fibbonacci {
    public static void main(String[] args) {
        FibbonacciFinder finder = new FibbonacciFinder();
        System.out.println(finder.findSeriesIterative(10)); // Call for iterative method
        System.out.println(finder.findSeriesRecursive(10)); // Call for recursive method
    }
}
