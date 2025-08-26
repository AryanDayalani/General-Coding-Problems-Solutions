import java.util.*;

/*Brute force approach*/
public class ThreeSumBrute {
    public void threeSumBrute(int[] nums, int target) {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        for (counter1 = 0; counter1 < nums.length; counter1++) {
            for (counter2 = counter1 + 1; counter2 < nums.length; counter2++) {
                for (counter3 = counter2 + 1; counter3 < nums.length; counter3++) {
                    if (nums[counter1] + nums[counter2] + nums[counter3] == target) {
                        System.out.println(
                                "Triplet is: " + nums[counter1] + ", " + nums[counter2] + ", " + nums[counter3]);
                    } else {
                        System.out.println("No triplet found");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeSumBrute trial_instance = new ThreeSumBrute();
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int target = 3;
        trial_instance.threeSumBrute(arr, target);
    }
}