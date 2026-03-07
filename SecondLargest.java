class FindSecondLargest {

    // function to find the largest element in the array
    public int largestFinder(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }
        }
        return largest;
    }

    // function to find the second largest element in the array
    public int SecondLargestFinder(int numbers[]) {
        int largest = largestFinder(numbers);
        int second_largest = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > second_largest && number < largest) {
                second_largest = number;
            }
        }
        return second_largest;
    }
}

public class SecondLargest {
    public static void main (String[]args) {
    int[] numbers = {1,2,3,4,6,18,19,2};
    FindSecondLargest finder = new FindSecondLargest();
    int second_largest = finder.SecondLargestFinder(numbers);   // function call
    System.out.print(second_largest);
    }
}
