package STEP;

import java.util.*;

class ParanthesisCheck {
    public boolean paranthesisChecker(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

public class ValidParanthesis {
    public static void main(String[] args) {
        ParanthesisCheck checker = new ParanthesisCheck();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of parentheses: ");
        String s = sc.nextLine();
        boolean isValid = checker.paranthesisChecker(s);
        System.out.println("Is valid: " + isValid);
        sc.close();
    }
}
