package dfs;

public class SudokuSolver {

    public boolean[][] row = new boolean[9][9];
    public boolean[][] column = new boolean[9][9];

    public boolean[][][] partition = new boolean[3][3][9];

    public void solveSudoku(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    row[i][t] = true;
                    column[j][t] = true;
                    partition[i/3][j/3][t] = true;
                }


                // t in specific column and row and 3 by 3 partition exists
            }
        }
        dfs(board, 0,0);
    }


    // Recurrence the place
    public boolean dfs(char[][] board, int x, int y){
        if (y == 9){
            x++;
            y = 0;
        }
        if (x == 9) return true; // The end condition

        if (board[x][y] != '.') return dfs(board, x, y+1); // The skip condition

        // The DFS algorithm

        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !column[y][i] && !partition[x / 3][y / 3][i]){
                board[x][y] = (char) (i + '1');
                row[x][i] = column[y][i] = partition[x/3][y/3][i] = true;
                if (dfs(board,x,y+1)) return true; // iterate next place and correct value in (x,y)
                board[x][y] = '.';
                row[x][i] = column[y][i] = partition[x/3][y/3][i] = false;
                // return initial value and try the next value
            }
        }
        return false; // back to the iterating place
    }

    public static void main(String[] args) {
        SudokuSolver test = new SudokuSolver();



        String[][] stringarr = {
                {".",".","7","6",".","5","9","4","."},
                {".",".",".",".",".",".",".",".","6"},
                {"8",".",".","1",".",".",".",".","."},
                {".",".",".",".",".",".","2",".","."},
                {".","7",".",".","9",".",".",".","."},
                {".",".","9",".",".","4","5","3","."},
                {".","1",".","5",".",".","3","6","."},
                {".",".",".",".",".","6",".",".","7"},
                {".",".","3",".",".",".",".",".","2"}};

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = stringarr[i][j].charAt(0);
            }
        }

//
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};
        test.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    }

}
