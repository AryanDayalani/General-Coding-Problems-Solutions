class MinMaxFinder {

    // Minimum finder
    public int minimum(int[] numbers) {
        int minimum = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < minimum) {
                minimum = number;
            }
        }
        return minimum;
    }

    // Maximum finder
    public int maximum(int[] numbers) {
        int maximum = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }
}

public class ArrayMinMax {
    public static void main(String[] args) {
        int[] numbers = { 29, 23, 47, 94, 47 };
        MinMaxFinder finder = new MinMaxFinder();
        int minimum = finder.minimum(numbers); // function call for min
        int maximum = finder.maximum(numbers); // function call for max
        System.out.println("Minimum and Maximum values are " + minimum + " " + maximum + " respectively");
    }
}
