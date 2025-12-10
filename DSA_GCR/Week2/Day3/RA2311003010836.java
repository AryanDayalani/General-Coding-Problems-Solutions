// This is Week 2, Day 3. Problem solved is Next Greater Node In Linked List 

package DSA_GCR.Week2.Day3;

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

class NextLarger {
    public int[] nextLargerNodes(ListNode head) {
        // --- Calculate length ---
        int length = 0;
        ListNode counter = head;
        while (counter != null) {
            length++;
            counter = counter.next;
        }

        int[] answer = new int[length]; // Initialize answer array with the correct length.
        int i = 0;

        ListNode iter = head;

        while (iter != null) {
            ListNode temp = iter.next; // Start 'temp' just ahead of 'iter'

            // The inner loop either breaks when a larger value is found,
            // or finishes when temp becomes null (end of list reached for this iter).
            while (temp != null) {
                if (temp.val > iter.val) {
                    answer[i] = temp.val;
                    break; // Exit the inner loop immediately
                }
                temp = temp.next;
            }

            // If we broke the inner loop, answer[i] is already set correctly.
            // If the inner loop finished naturally, answer[i] remains 0 by default
            // because the array was initialized with zeros.

            // Move to the next element in the main list and increment index
            iter = iter.next;
            i++;
        }
        return answer;
    }
}

public class RA2311003010836 {
    public static void main(String[] args) {
        // You can add test cases here to test the Solution class if needed.
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        NextLarger nl = new NextLarger();
        int[] result = nl.nextLargerNodes(node1);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
