// Java implementation of Word Search problem
import java.util.*;

class WordSearcher {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return false;
        }
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(word, i, j, board, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(String word, int r, int c, char[][] board, boolean[][] visited) {
        boolean found = false;
        // Base Case - if word string is empty, target word is processed and found, return true
        if (word.isEmpty()) {
            return true;
        } 
        else {
            // return false if out of bounds or the next 
            if (r>=board.length || c>=board[0].length || r<0 || c<0 || board[r][c] != word.charAt(0) || visited[r][c]) {
                return false;
            }
            else {
                // mark it as visited
                visited[r][c] = true;

                found = search(word.substring(1), r+1, c, board, visited) ||
                search(word.substring(1), r-1, c, board,visited) ||
                search(word.substring(1), r, c+1, board, visited) ||
                search(word.substring(1), r, c-1, board, visited);

                // backtrack
                visited[r][c] = false;
            }
        }
        return found;
    }
}

public class WordSearch {
    public static void main(String[] args) {
        WordSearcher searcher = new WordSearcher();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println("Does the board contain the word '" + word1 + "'? " + searcher.exist(board, word1)); // true
        System.out.println("Does the board contain the word '" + word2 + "'? " + searcher.exist(board, word2)); // true
        System.out.println("Does the board contain the word '" + word3 + "'? " + searcher.exist(board, word3)); // false
    }
}
