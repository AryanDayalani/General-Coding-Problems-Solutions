package STEP;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class MiddleFinder {
    public ListNode findmiddleNode(ListNode head) {
        ListNode slow = head;   // Will move 1 step 
        ListNode fast = head;   // Will move 2 steps

        while (fast != null && fast.next != null) {     // At the end, fast will be at the last node and slow would've covered only half the list length as speed of fast is 2 times the speed of slow, thus at the end slow will be on mid node

            fast = fast.next.next;  // 2 steps
            slow = slow.next;   // 1 step
        }

        return slow;    // At end, slow == mid node
    }
}

public class MiddleNode {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);

        MiddleFinder finder = new MiddleFinder();
        ListNode mid = finder.findmiddleNode(head);

        System.out.println("Middle node value is: "+mid.val);
    }
}