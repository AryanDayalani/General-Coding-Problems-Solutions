import java.util.*;

public class UsernameGenerator {
    public String generateUsername(String name, int year) {
        // For checking edge case 1 of year out of bounds
        if (year < 1000 || year > 10000) {
            return "Invalid Year";
        }
        if (name.isEmpty()) {
            System.out.println("Please enter a valid name!");
        }

        String firstName = name.trim().split(" ")[0].toLowerCase();
        String lastTwoDigits = String.valueOf(year).substring(2);

        return firstName + lastTwoDigits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsernameGenerator generator = new UsernameGenerator();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birth-year: ");
        int year = scanner.nextInt();
        String formatted = generator.generateUsername(name, year);
        System.out.println("Formatted name: " + formatted);
        scanner.close();
    }
}
