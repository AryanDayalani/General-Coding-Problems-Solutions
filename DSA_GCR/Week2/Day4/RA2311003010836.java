// Week 2, Day 4 - Find the maximum twin sum in a linked list - Optimal Approach giving O(N) time and O(1) space complexity

package DSA_GCR.Week2.Day4;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class MaxTwinSum {

    // Function to reverse a linked list
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode ahead = null;
        while(curr !=null){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr=ahead;
        }
        return prev;
    }

    // Function to find the maximum twin sum - Core Logic
    public int pairSum(ListNode head) {    

    // Finding mid using slow and fast pointer
    ListNode slow = head;   
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    // After this loop, slow is at mid


    ListNode rev = reverse(slow); // Reversing the second half of the linked list

    // Now, we have two linked lists - first half starting from head and second half starting from rev (reversed second half)
    ListNode temp = head;

    int max = 0;
    while(rev !=null){
        if(temp.val + rev.val > max){
            max = temp.val + rev.val;        
        }
        rev = rev.next;
        temp=temp.next;
    }
    return max;
        }
    }

public class RA2311003010836 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);            
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        MaxTwinSum obj = new MaxTwinSum();
        int result = obj.pairSum(head);
        System.out.println("The maximum twin sum is: " + result);
    }
    
}

        /*
        // Array Approach - Space and Time both O(N)

        // Finding size/length of the linked list
        int length = 0;     
        ListNode count = head;
        while (count != null) {
            length++;
            count = count.next;
        }

        int mid = length/2;     // Mid of the linked list length 

        int[] arr = new int[length];    // Create an array of size=length for storing the Linked List 

        // Storing the values of the Linked List into the array - in order
        ListNode iter = head;
        int index = 0;
        while (iter != null) {
            arr[index] = iter.val;
            index++;
            iter = iter.next; 
        }
        
        // Core Logic - Finding the max twin sum by adding an element and its twin (using the n-1-i logic given in the question description to access twin element) 
        int max = 0;
        int sum = 0;
        for (int arr_index = 0; arr_index < mid; arr_index++) {
            sum = arr[arr_index] + arr[length-1-arr_index];
            if (sum > max) max = sum;
        }

        return max;
        */
        
    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /* This is an logic I was following to reverse the array from the mid, 
        it gives TLE and above this is the array approach solution that easily solves without reversal, thus reversal in array is unneccesary. 
        We can solve without reversing in the array approach because of the random(direct) access nature of the array.        

        
        for (arr_index = mid; arr_index < length; arr_index++) {
            arr_index = (length-1-arr_index);
        }

        int j = 0;
        int k = mid;
        int max = 0;
        int sum = 0;
        while (j < length/2 && k < length) {
                sum = arr[j]+arr[k];
                if (max < sum) {
                    max = sum;
                }
                j++;
                k++;
            }
        return max;
        
        */