// This is Week 2, Day 5 - Remove nodes from linked list which have a greater value on right side - Optimal Approach giving O(N) time and O(1) space complexity

package DSA_GCR.Week2.Day5;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class RemoveNodes {

    // Helper method to reverse a linked list
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        // 1. Reverse the list. The original 'right side' is now the 'left side'.
        ListNode revHead = reverseList(head);

        // 2. Traverse the reversed list, maintaining the maximum value seen so far.
        ListNode current = revHead;
        // The head of the reversed list is always a 'max' candidate to keep.
        int maxVal = revHead.val; 

        // We use 'current' to traverse, and modify 'current.next' pointers.
        while (current != null && current.next != null) {
            
            // If the *next* node's value is LESS than the max seen so far, 
            // it means the original node had a larger value to its *right* and must be removed.
            if (current.next.val < maxVal) {
                // Skip the node by linking 'current' directly to the node after the one we are removing.
                current.next = current.next.next;
                // IMPORTANT: Do not advance 'current' here, as the *new* current.next 
                // must also be checked against the *same* maxVal in the next iteration.
            } else {
                // The current.next node is a new maximum (or equal). 
                // Update maxVal and safely move 'current' forward to this new max node.
                maxVal = Math.max(maxVal, current.next.val);
                current = current.next;
            }
        }
        
        // 3. Reverse the modified list back to its original orientation and return the new head.
        ListNode ans = reverseList(revHead);
        return ans;
    }
}


public class RA2311003010836 {
    public static void main(String[] args) {
        // Creating the linked list: 12 -> 15 -> 10 -> 11 -> 5 -> 6 -> 2 -> 3
        ListNode head = new ListNode(12);
        head.next = new ListNode(15);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(3);

        RemoveNodes remover = new RemoveNodes();
        ListNode modifiedHead = remover.removeNodes(head);

        // Print the modified linked list
        System.out.print("Modified Linked List: ");
        ListNode current = modifiedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
