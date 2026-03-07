class Star {
    public void printStars(int number) {
        if (number == 1) {
            System.out.println("*");
        } else {
        int n = 1;
        while (n <= number) {
            System.out.println(" ".repeat(number - n) + "*".repeat(n));
            n = n+1;
        }
    }
    }
}
public class StarPrinter {
    public static void main(String[] args) {
        Star s = new Star();
        s.printStars(4);
    }
}
