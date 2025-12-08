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

class PartitionList {
    public ListNode partition(ListNode head) {
        ListNode even_list = new ListNode();        // While decalring these are the starting nodes, when we keep adding nodes
                                                    // according to the odd/even condition, more nodes join in to form a list.

        ListNode odd_list = new ListNode();         // Same as above

        ListNode even_curr = even_list;
        ListNode odd_curr = odd_list;

        while (head != null) {
            if (head.val % 2 == 0) {                // Condition to check if the value is even
                even_curr.next = head;              // Set the next of the even list pointer to head
                even_curr = even_curr.next;         // Move the pointer to the next position
            }

            else {
                odd_curr.next = head;               // Same as above, only change is condition for odd list
                odd_curr = odd_curr.next;
            }

            head = head.next;                       // Next node in the original list
        }

        even_curr.next = odd_list.next;             // Link the two lists
        odd_curr.next = null;                       // Set last node.next to null indicating the end

        return even_list.next;
    }
}

public class OddEvenLists {
    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode partitionedHead = pl.partition(head);

        // Print the partitioned list
        ListNode current = partitionedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
