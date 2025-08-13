import java.util.LinkedList;

public class SimpleLRU {
    private LinkedList<Integer> list = new LinkedList<>();
    private int capacity;

    public SimpleLRU(int capacity) {
        this.capacity = capacity;
    }

    public void access(int value) {
        // If present remove first occurrence (O(n)), then add to front
        list.removeFirstOccurrence(value);
        list.addFirst(value);
        if (list.size() > capacity) {
            list.removeLast(); // evict LRU
        }
    }

    public void printCache() {
        System.out.println("Cache (MRU->LRU): " + list);
    }

    public static void main(String[] args) {
        SimpleLRU cache = new SimpleLRU(3);
        cache.access(1);
        cache.access(2);
        cache.access(3);
        cache.printCache(); // Output: Cache (MRU->LRU): [3, 2, 1]
        
        cache.access(2);
        cache.printCache(); // Output: Cache (MRU->LRU): [2, 3, 1]
        
        cache.access(4);
        cache.printCache(); // Output: Cache (MRU->LRU): [4, 2, 3]
        
        cache.access(1);
        cache.printCache(); // Output: Cache (MRU->LRU): [1, 4, 2]
    }
}
