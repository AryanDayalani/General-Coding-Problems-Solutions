package STEP;

import java.util.Scanner;

public class ReverseLetters {
    public static String reverseLetters(String s) {
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
        for (int j = 0; j < wordCount; j++) {
            String word = words[j];
            String reversedWord = "";
            for (int k = word.length() - 1; k >= 0; k--) {
                reversedWord += word.charAt(k);
            }
            result += reversedWord;
            if (j < wordCount - 1) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your sentence: ");
        String input = sc.nextLine();
        System.out.println("The reverse-lettered sentence is: " + reverseLetters(input));
        sc.close();

    }
}
