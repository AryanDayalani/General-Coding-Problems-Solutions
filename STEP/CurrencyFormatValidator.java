package STEP;
import java.util.Scanner;

public class CurrencyFormatValidator {

    public static boolean isValidCurrency(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }

        s = s.trim();
        return isValidUSD(s) || isValidEUR(s) || isValidGBP(s);
    }

    public static boolean isValidUSD(String s) {
        if (s.startsWith("$")) {
            String rest = s.substring(1);
            return checkFormat(rest, '.');
        }

        if (s.endsWith(" USD")) {
            String rest = s.substring(0, s.length() - 4);
            return checkFormat(rest, '.');
        }

        return false;
    }

    public static boolean isValidEUR(String s) {
        if (s.startsWith("€")) {
            String rest = s.substring(1);
            return checkFormat(rest, ',');
        }

        if (s.endsWith(" EUR")) {
            String rest = s.substring(0, s.length() - 4);
            return checkFormat(rest, ',');
        }

        return false;
    }

    public static boolean isValidGBP(String s) {
        if (s.startsWith("£")) {
            String rest = s.substring(1);
            return checkFormat(rest, '.');
        }

        if (s.endsWith(" GBP")) {
            String rest = s.substring(0, s.length() - 4);
            return checkFormat(rest, '.');
        }

        return false;
    }

    public static boolean checkFormat(String s, char decimal) {
        int idx = s.lastIndexOf(decimal);

        if (idx == -1) {
            return false;
        }

        String num = s.substring(0, idx);
        String dec = s.substring(idx + 1);

        if (dec.length() != 2) {
            return false;
        }

        if (!isAllDigits(dec)) {
            return false;
        }

        if (num.isEmpty()) {
            return false;
        }

        if (!isValidNumber(num)) {
            return false;
        }

        return true;
    }

    public static boolean isValidNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != ',' && c != '.') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllDigits(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter currency (or 'exit' to quit): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Ended.");
                break;
            }

            if (isValidCurrency(input)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }

        sc.close();
    }
}
