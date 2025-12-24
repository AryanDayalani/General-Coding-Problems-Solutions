// Remove Duplicates from Sorted List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class DuplicateRemover {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp1 = head;
        
        // Check for same values next to each other
        while (temp1 != null && temp1.next != null ){
            ListNode temp2 = temp1.next;
            while (temp2 != null) {
                if (temp2.val == temp1.val) {
                temp1.next = temp2.next;    // if same value, skip temp2 - the node after current node
            }
            temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return head;
    }
}


/* Single Pointer Approach


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode temp = head;

        while (temp != null) {

            if (temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }

            else
                temp = temp.next;

        }

        return head;
    }
}

*/


public class RemoveDuplicates {
    public static void main(String[] args) {
        DuplicateRemover dr = new DuplicateRemover();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode updatedHead = dr.deleteDuplicates(head);

        // Print the updated list
        ListNode current = updatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    
}
