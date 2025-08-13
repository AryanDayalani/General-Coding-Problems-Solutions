public class UniqueAlphabets {
    public static void  main(String[] args) {
        String input = "aaabbbccdddeeeee";
        String result = "";

        for (int index = 0; index<input.length(); index++) {
            char currentCharacter = input.charAt(index);

            if (result.indexOf(currentCharacter) == -1) {
                result += currentCharacter;
            }
        }
        System.out.println("Unique Characters are:" + result);
    }
}
