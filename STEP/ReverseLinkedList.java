// This is a code to reverse a Linked List iteratively

package STEP;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;   // This is null as the prev of head node is null in the beginning
        ListNode curr = head;   // The node being reversed
        ListNode next;  // This will hold the node after the node being reversed

        while(curr != null) {
            next = curr.next;   // This step will set the next node for each iteration, everytime making the next node of the current node being considered for reversal as the Next temp variable

            curr.next = prev;   // Actual link reversal

            prev = curr;    // Taking prev
            curr = next;    // and curr one step forward
        }
        return prev;
    }
}

public class ReverseLinkedList {
           
        public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        Reverse reverser = new Reverse();
        ListNode newHead = reverser.reverseList(head);

        //printing the reversed linked list
        ListNode temp = newHead;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        }
        
}
