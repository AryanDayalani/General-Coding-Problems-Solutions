
// Group Anagrams problem - Leetcode 49

// Necessary imports
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class GroupAnagrammer {
    public List<List<String>> groupAnagrams(String[] strs) {

        // A hashmap that will store the sorted word as a key and the List of anagrams as a value
        HashMap<String, List<String>> map = new HashMap<>();

        // For each string, 
        for (String str : strs) {

            // Convert each str to arr and sort it, convert back to string
            char[] str_arr = str.toCharArray();
            Arrays.sort(str_arr);
            String sorted_word = new String(str_arr);   

            // if map does not have the sorted word as a key, add it as a new key and empty ArrayList to store future anagrams
            if (!map.containsKey(sorted_word)) {
                map.put(sorted_word, new ArrayList<>());
            }

            // Else, map already contains the sorted word as a key, fetch its corresponding array and add the current str into the array of its anagrams
            map.get(sorted_word).add(str);
        }

        // Return all the anagrams as a list of lists.
        return new ArrayList<>(map.values());
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"ate", "bat", "eat", "row", "tab", "tea"};
        
        GroupAnagrammer ga = new GroupAnagrammer();
        List<List<String>> ans = new ArrayList<>();
        ans = ga.groupAnagrams(strs);

        System.out.println(ans);
    }
}
