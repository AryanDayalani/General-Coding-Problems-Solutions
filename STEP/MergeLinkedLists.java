package STEP;

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

class Merge {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1; // This will iterate list1
        ListNode temp2 = list2; // This will iterate list2
        ListNode dummy = new ListNode(-1); // This will help return the initial node
        ListNode head = dummy; // Head of new merged list

        // Loop runs only while both lists have nodes to compare
        while (temp1 != null && temp2 != null) {

            // Attach the smaller node of the two lists into the merged list to merge in a
            // sorted manner
            if (temp1.val <= temp2.val) {
                head.next = temp1;
                temp1 = temp1.next;
            } else {
                head.next = temp2;
                temp2 = temp2.next;
            }
            head = head.next; // Moved down to avoid repetition
        }

        // Check for leftover nodes of either of the lists
        if (temp1 != null) {
            head.next = temp1;
        }
        if (temp2 != null) {
            head.next = temp2;
        }

        // Return the start of the new merged list
        return dummy.next;
    }
}

public class MergeLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        Merge merger = new Merge();
        ListNode mergedHead = merger.mergeTwoLists(list1, list2);

        // printing the merged linked list
        ListNode temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
