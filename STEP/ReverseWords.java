package STEP;

import java.util.Scanner;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = new String[s.length()];
        int wordCount = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                int start = i;
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
                words[wordCount] = s.substring(start, i);
                wordCount++;
            } else {
                i++;
            }
        }

        String result = "";
        for (int j = wordCount - 1; j >= 0; j--) {
            result += words[j];
            if (j > 0) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your sentence: ");
        String input = sc.nextLine();
        System.out.println("The reversed sentence is: " + reverseWords(input));
        sc.close();

    }
}
