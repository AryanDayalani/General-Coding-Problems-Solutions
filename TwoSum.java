// The hashmap approach to solve optimally
import java.util.HashMap;

class TwoSummer {
    public int[] twoSum(int[] nums, int target) {

        // Hashmap to store the values and indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Final result array
        int[] result = new int[2];

        // For each number in list,
        for (int i = 0; i<nums.length; i++) {
            int diff = target - nums[i];    // find the diff between number and the target
            if (map.containsKey(diff)) {    // if the diff is already present as a key in map, add the index and the value of the diff key into the result array
                result[0] = i;
                result[1] = map.get(diff);
                return result;
             }
             map.put(nums[i], i);   // else, add the number at the ith index as a key and the index 'i' as a value to the map
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
