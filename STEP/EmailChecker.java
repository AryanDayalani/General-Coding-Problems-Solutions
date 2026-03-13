package STEP;

public class EmailChecker {
    public String checkValidity(String email) {
        if (email == null) {
            return "Invalid!";
        }
        
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@') || atIndex == email.length() - 1) {
            return "Invalid!"; // no '@', multiple '@' or nothing after '@'
        }

        String lower = email.toLowerCase();
        if (lower.endsWith(".com") || lower.endsWith(".in")) {
            return "Valid";
        }

        return "Invalid!";
    }
}
