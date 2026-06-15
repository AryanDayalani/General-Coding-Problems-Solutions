// This is an array problem to find the missing and repeating number in an array of size n having elements from [1,n]

package STEP;

class Finder {
    public void findMissingDuplicate(int nums_size, int[] nums) {

        int[] count = new int[nums_size + 1];

        for (int index = 0; index < nums_size; index++) {
            count[nums[index]]++;
        }

        for (int index = 1; index <= nums_size; index++) {
            if (count[index] == 2) {
                System.out.println("The duplicate number is: " + index);
            }
            if (count[index] == 0) {
                System.out.println("The missing number is: " + index);
            }
        }
    }
}

public class FindMissingAndRepeating {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        int nums_size = nums.length;

        Finder finder = new Finder();
        finder.findMissingDuplicate(nums_size, nums);
    }
}
