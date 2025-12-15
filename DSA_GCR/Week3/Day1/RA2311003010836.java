// Week 3, Day 1 - Valid Parentheses (Standard Stack Implementation)

package DSA_GCR.Week3.Day1;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // Using the Stack to push characters 
        
        // Iterating for each char in the string
        for (char curr : s.toCharArray()) {
            if (curr == '{' || curr == '(' || curr == '[') {    // If it is a open parentheses
                stack.push(curr);   // push it into stack
            } else {
                if (stack.isEmpty()) {
                    return false;   // empty stack = unbalanced
                } 

                char top = stack.pop();     // This is the top element of the array

                // Check for each parentheses type
                if (curr == ')' && top != '(') {
                    return false;
                }
                if (curr == ']' && top != '[') {
                    return false;
                }
                if (curr == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // If empty (empty = balanced), isEmpty() returns true; false otherwise
    }
}

public class RA2311003010836 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String test1 = "()";
        System.out.println("Is \"" + test1 + "\" valid? " + sol.isValid(test1)); // true

        String test2 = "()[]{}";
        System.out.println("Is \"" + test2 + "\" valid? " + sol.isValid(test2)); // true

        String test3 = "(]";
        System.out.println("Is \"" + test3 + "\" valid? " + sol.isValid(test3)); // false

        String test4 = "([)]";
        System.out.println("Is \"" + test4 + "\" valid? " + sol.isValid(test4)); // false

        String test5 = "{[]}";
        System.out.println("Is \"" + test5 + "\" valid? " + sol.isValid(test5)); // true
    }
}