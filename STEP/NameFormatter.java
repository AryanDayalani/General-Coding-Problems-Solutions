package STEP;
import java.util.Scanner;

public class NameFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String input = scanner.nextLine();
        String formatted = formatName(input);
        System.out.println("Formatted name: " + formatted);
        scanner.close();
    }

    public static String formatName(String name) {
        String result = "";
        for (String part : name.trim().split("\\s+")) {
            result += part.substring(0, 1).toUpperCase() +
                    part.substring(1).toLowerCase() + " ";
        }
        return result.trim();
    }
}
