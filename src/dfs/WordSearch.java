package dfs;

public class WordSearch {
    // leetcode 79



    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        char[][] board = {{'A'}, {'A'}};
        test.exist(board, "AA");
    }
    public boolean exist(char[][] board, String word) {
        if (word.length() == 1){
            for (int i = 0; i < board.length ; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j]){
                        return true;
                    }
                }
            }
            return false;
         } // special case 1

        boolean[][] table = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]){
                    if(dfs(board, table, word, i, j)){
                        return true;
                    }
                }
            }
        }



        return false;
    }

    public boolean dfs(char[][] board, boolean[][] table, String word, int row, int col){
        if ((word.length() == 1 && word.charAt(0) == board[row][col]) || word.length() == 0){
            return true; // end condition
        }


        if (word.charAt(0) == board[row][col] && !table[row][col]){ // initial condition
            table[row][col] = true;
            if (row > 0) {
                if (!table[row - 1][col] && dfs(board, table, word.substring(1), row - 1, col)){// up
                    return true;
                }
            }
            if (col > 0){
                if (!table[row][col - 1] && dfs(board, table, word.substring(1), row, col - 1)){
                    return true;// left
                }
            }
            if (col < board[0].length - 1){
                if (!table[row][col + 1] && dfs(board, table, word.substring(1), row, col + 1)){
                    return true;// right
                }
            }
            if (row < board.length - 1){
                if (!table[row + 1][col] && dfs(board, table, word.substring(1), row + 1, col)){
                    return true;// down
                }
            }
        }
        table[row][col] = false;
        return false;
    }
}
