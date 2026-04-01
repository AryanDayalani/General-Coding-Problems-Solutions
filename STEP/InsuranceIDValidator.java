package STEP;

import java.util.Scanner;

public class InsuranceIDValidator {

    public static boolean isValidInsuranceID(String idString) {
        if (idString == null || idString.length() != 11) {
            return false;
        }

        if (idString.charAt(3) != '-' || idString.charAt(8) != '-') {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            char c = idString.charAt(i);
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }

        for (int i = 4; i < 9; i++) {
            char c = idString.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }

        char lastChar = idString.charAt(10);
        if (lastChar < '0' || lastChar > '9') {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            char letter = idString.charAt(i);
            int position = letter - 'A' + 1;
            sum = sum + position;
        }

        for (int i = 4; i < 9; i++) {
            char digit = idString.charAt(i);
            int value = digit - '0';
            sum = sum + value;
        }

        int calculatedChecksum = sum % 10;
        int providedChecksum = lastChar - '0';

        if (calculatedChecksum == providedChecksum) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Insurance ID (or type 'exit' to quit): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            boolean isValid = isValidInsuranceID(input);

            if (isValid) {
                System.out.println("Result: VALID");
            } else {
                System.out.println("Result: INVALID");
            }
        }
        
        sc.close();
    }
}
