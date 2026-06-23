// The hashmap approach to solve optimally
import java.util.HashMap;

class TwoSummer {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = i;
                result[1] = map.get(diff);
                return result;
             }
             map.put(nums[i], i);
        }
        return result;
    }
}

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {10, 7, 11, 19, 30};
        int target  = 41;

        TwoSummer ts = new TwoSummer();
        int[] result = ts.twoSum(nums, target);

        System.out.print("[" + result[0] + ", " + result[1] + "]");
    }
}
