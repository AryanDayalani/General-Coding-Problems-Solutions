// Brute force approach of Restore IP addresses (No recursion, backtrack)
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();    // List to store answer
        int len = s.length();    // input string length
        
        // iterate at a lengths of 3 chars per iterator
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);    // create 4 substrings
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){    // if all valid, add to result in IP address format
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)    // invalid if either condition fails
            return false;
        return true;
    }
}

public class RestoreIPAddressesBrute {
    public static void main (String[]  args) {
        String s = "25525511135";
        Solution sol = new Solution();
        List<String> res = sol.restoreIpAddresses(s);
        System.out.println(res);
    }
}
