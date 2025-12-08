package DSA_GCR.Week2.Day1;


// Day 1 - Partition a linked list around a value, and preserve the original relative order of the nodes in each of the two partitions.

//Definition for singly-linked list.

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode small_list = new ListNode();  // While decalring these are the starting nodes, when we keep adding nodes according to the > or < condition, more nodes join in to form a list.

        ListNode big_list = new ListNode();    // Same as above

        ListNode small_curr = small_list;
        ListNode big_curr = big_list;

        while (head!=null) {
            if (head.val < x) {
                small_curr.next = head;         // Set the next of the small list pointer to head 
                small_curr = small_curr.next;   // Move the pointer to the next position
            }
            else {
                big_curr.next = head;           // Same as above, only change is condition (>=)
                big_curr = big_curr.next;
            }
            head=head.next;     // Next node in the original list
        }

        small_curr.next = big_list.next;    // Link the two lists
        big_curr.next = null;               // Set last node.next to null indicating the end

        return small_list.next;
    }
}
public class RA2311003010836 {
    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        ListNode partitionedHead = pl.partition(head, x);

        // Print the partitioned list
        ListNode current = partitionedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
