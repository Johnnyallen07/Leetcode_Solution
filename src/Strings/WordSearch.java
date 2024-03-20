package Strings;
import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    // Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
    // Output: ["eat","oath"]

    int index = 1;

    // test case
    // {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a', 'f','l','v'}};
    // {"oa", "oaa"};

    // {{'a', 'a'}}
    // {"aa"}

    //{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
    //{"abcdefg", "befa","eaabcdgfa"}

    // dfs only but the time exceeds when the data is too large
    public static void main(String[] args) {
        char[][] board = {{'a','b'}, {'a','a'}};

        String[] words = {"bab"};
        WordSearch test = new WordSearch();
        List<String> result = test.findWords(board, words);
        System.out.println(result);


    }

    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] position = new boolean[board.length][board[0].length];
        List<String> storage = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char s = words[i].charAt(0);
            boolean repeat = false;
            for (int j = 0; j < board.length; j++) { // row
                for (int k = 0; k < board[0].length; k++) { // column
                    if (board[j][k] == s){
                        if(dfs(board, position, words[i], j, k)){
                            for (int l = 0; l < storage.size(); l++) {
                                if (storage.get(l).equals(words[i])) {
                                    repeat = true;
                                    break;
                                }
                            }
                            if (!repeat) {
                                storage.add(words[i]);
                            }

                        }
                        index = 1;
                        position = new boolean[board.length][board[0].length];
                        repeat = false;
                    }
                }
            }
        }
        return storage;
    }

    public boolean dfs(char[][] board, boolean[][] position, String word, int x, int y){

        if (index == word.length()){
            return true;
        }

        position[x][y] = true;

        // left
        if (y > 0 && !position[x][y-1] && board[x][y-1] == word.charAt(index)){

            index++;
            if(dfs(board, position, word, x, y-1)) return true;
            index--;
            position[x][y-1] = false;


        }
        // right
        if (y < board[0].length - 1 && !position[x][y+1]  && board[x][y+1] == word.charAt(index)){

            index++;
            if(dfs(board, position, word, x, y+1)) return true;
            index--;
            position[x][y+1] = false;

        }
        // up
        if (x > 0 && !position[x-1][y] && board[x-1][y] == word.charAt(index)){

            index++;
            if(dfs(board, position, word, x-1, y)) return true;
            index--;
            position[x-1][y] = false;

        }
        // down
        if (x < board.length - 1 && !position[x+1][y] && board[x+1][y] == word.charAt(index)){

            index++;
            if(dfs(board, position, word, x+1, y)) return true;
            index--;
            position[x+1][y] = false;
        }


        return false;
    }




}
