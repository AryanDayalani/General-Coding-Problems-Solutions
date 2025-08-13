//Create Node class with necessary parameters
class Node {
    int value;
    Node next, previous;

    public Node(int value) {
        this.value = value;
    }
}


//LRU Cache system Implementation class
public class LRU {
    private Node head, tail;
    private int capacity, size;

    public LRU(int capacity) {
        this.capacity = capacity;      //max cache capacity
        this.size = 0;                 //current size
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;              //in empty state, head and tail point each other          
        tail.previous = head;
    }

		//function to add a node
    private void addNode(Node node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }

		//funtion to remove a node
    private void removeNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

		//function to remove the LRU node 
    private Node removeTail() {
        Node lastReal = tail.previous;
        if (lastReal == head) return null;
        removeNode(lastReal);
        return lastReal;
    }

		//function to update the MRU node
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

		//function to check whether node is present in cache, if yes update to head else add
    public void accessNode(int value) {
        Node temp = head.next;
        while (temp != tail) {
            if (temp.value == value) {
                moveToHead(temp);
                return;
            }
            temp = temp.next;
        }

        Node newNode = new Node(value);
        addNode(newNode);
        size++;

        if (size > capacity) {
            if (removeTail() != null) size--;
        }
    }

    public void printCache() {
        Node temp = head.next;
        System.out.print("Cache (MRU -> LRU): ");
        while (temp != tail) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }


//Main Class
    public static void main(String[] args) {
        LRU cache = new LRU(3);
        cache.accessNode(1);
        cache.accessNode(2);
        cache.accessNode(3);
        cache.printCache(); // 3 2 1
        cache.accessNode(2);
        cache.printCache(); // 2 3 1
        cache.accessNode(4);
        cache.printCache(); // 4 2 3
    }
}
