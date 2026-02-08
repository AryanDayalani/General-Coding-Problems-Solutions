// Java implementation for Combination Sum III
import java.util.*;

class CombinationFinder {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();

        if (k>n) {
            return new ArrayList<>();   // if no of digits > sum, combo is impossible
        }

        findCombination(k, 1, n, new ArrayList<>(), answer);
        return answer; 
    }

    public static void findCombination(int k, int num, int target, ArrayList<Integer> curr, List<List<Integer>> answer) {
        // If target is reached and k elements are used
        if (target == 0 && k == 0) {
            answer.add(new ArrayList<>(curr));
            return;
        }

        for (int i = num; i < 10; i++) {
            if (i > target || k <= 0) break; // Prune unnecessary calls
            curr.add(i); // Choose the current number
            findCombination(k - 1, i + 1, target - i, curr, answer); // Recurse
            curr.remove(curr.size() - 1); // Backtrack
        }
    }
}

public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;

        CombinationFinder cf = new CombinationFinder();
        List<List<Integer>> answer = cf.combinationSum3(k, n);
        System.out.println(answer);
    }
}
