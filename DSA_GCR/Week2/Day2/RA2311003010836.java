// Day 2 - Swap Nodes in Pairs in a Linked List 

package DSA_GCR.Week2.Day2;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Swapper {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0, head); // Dummy node that points to the head always (helps to return the final
                                                // list, regardless of position of head)
        ListNode prev = new ListNode(); // Element before the pair to be swapped
        ListNode first = new ListNode(); // First element of the pair to be swapped
        ListNode second = new ListNode(); // Second element of the pair to be swapped

        // We can work only on a non-empty list
        if (head != null) {

            prev = dummy; // for the pair 1 and 2 to be swapped, prev should be the node just before 1,
                          // i.e, dummy.

            // We can work only if we have 2 non-empty nodes that can be swapped
            while (prev.next != null && prev.next.next != null) {

                first = prev.next; // first is set to prev.next
                second = prev.next.next; // first is set to prev.next.next (use prev.next.next, not first.next)

                // Swapping logic
                first.next = second.next; // First now points to third
                second.next = first; // Second points to first
                prev.next = second; // prev points to second, that means all links done swapped

                prev = first; // Update prev to now be the node just behind the next pair to be swapped
            }

            return dummy.next; // return dummy.next as it marks the beginning regardless of where head is at
                               // the moment
        }

        // For empty list, just return head
        else {
            return head;
        }
    }
}

public class RA2311003010836 {
    public static void main(String[] args) {
        // Creating a linked list 1->2->3->4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Swapper swapper = new Swapper();
        ListNode swappedHead = swapper.swapPairs(head);

        // Print the swapped linked list
        ListNode current = swappedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
