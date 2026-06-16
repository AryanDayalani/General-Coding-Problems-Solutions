// This code removes the Nth node from the end of a Linked List

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

class NRemove {
    public ListNode removeNth(ListNode head, int pos) {

        ListNode res = new ListNode(-1, head);
        ListNode dummy = res;

        for (int i = 0; i < pos; i++) {
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }

        dummy.next = dummy.next.next;

        return res.next;
    }
}

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        int pos = 3;

        NRemove remover = new NRemove();
        ListNode res = remover.removeNth(head, pos);

        ListNode temp = res;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
