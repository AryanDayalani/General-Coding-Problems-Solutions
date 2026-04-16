import java.util.*;

class TopKFinder {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Use a Min-Heap to keep the top K elements
        // Higher frequency elements stay in the heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll(); // Remove least frequent
        }

        // 3. Convert heap to result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}

public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        TopKFinder finder = new TopKFinder();
        int[] answer = finder.topKFrequent(arr, 2);
        System.out.println("Using standard min-heap so numbers will print in decreasing order of frequency (among the top-K most frequent survivors): ");
        for (int num : answer) {
            System.out.println(num);
        }
    }
}
