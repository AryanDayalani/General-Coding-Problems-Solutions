// Two pointer method to find if there is any cycle in a linked list

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Implementation Class
class CycleFinder {

    // Cycle Finding Function
    public boolean findCycle(ListNode head) {

        ListNode slow = head; // Pointer that moves behind
        ListNode fast = head; // Pointer that moves ahead

        while (fast != null && fast.next != null) {
            slow = slow.next; // Slow pointer moves one step at a time
            fast = fast.next.next; // Fast pointer moves twice the speed
            if (slow == fast)
                return true; // cycle found
        }
        return false; // no cycle found

    }
}

public class CycleDetectionLL {
    public static void main(String[] args) {

        // Creating a linked list with a cycle for testing
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle here

        CycleFinder cf = new CycleFinder();
        Boolean hasCycle = cf.findCycle(head);

        if (hasCycle) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle detected in the linked list.");
        }
    }
}