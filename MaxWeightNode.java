
// Finding the max weighted node - GFG problem
import java.util.Map;
import java.util.HashMap;

class Finder {
    public int maxWeightedCell(int[] exits) {

        // Store each node's weight in a map, where the key is the node index
        // and the value is the sum of source indices that point to that node.
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize every node weight to 0.
        for (int i = 0; i < exits.length; i++) {
            map.put(i, 0);
        }

        // For each source index i, add i to the weight of the exit node exits[i].
        for (int i = 0; i < exits.length; i++) {
            map.put(exits[i], map.getOrDefault(exits[i], 0) + i);
        }

        // Find the node with maximum weight. If weights tie, choose the highest index.
        int maxWeightedIndex = 0;
        for (int i = 0; i < exits.length; i++) {
            if (map.get(i) >= map.get(maxWeightedIndex)) {      // >= gets the highest index at tie situation
                maxWeightedIndex = i;
            }
        }

        return maxWeightedIndex;
    }
}

public class MaxWeightNode {
    public static void main(String[] args) {
        Finder finder = new Finder();

        int[] exits1 = { 1, 2, 0 };
        int result1 = finder.maxWeightedCell(exits1);
        System.out.println("Exits: [1, 2, 0] -> Max weighted node: " + result1);

        int[] exits2 = { 2, 2, 1, 3, 2 };
        int result2 = finder.maxWeightedCell(exits2);
        System.out.println("Exits: [2, 2, 1, 3, 2] -> Max weighted node: " + result2);
    }
}
