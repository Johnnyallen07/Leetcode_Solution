package solutions;

public class CXXX {
    private boolean[][] isChecked;
    private char[][] board;

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new CXXX().solve(board);
    }

    public void solve(char[][] board) {
        this.board = board;
        isChecked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isBorder(i, j) && board[i][j] == 'O'){
                    dfs(i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int x, int y) {
        board[x][y] = 'Y';
        isChecked[x][y] = true;
        if (isValid(x - 1, y)) {
            dfs(x - 1, y);
        }
        if (isValid(x + 1, y)) {
            dfs(x + 1, y);
        }
        if (isValid(x, y - 1)) {
            dfs(x, y - 1);
        }
        if (isValid(x, y + 1)) {
            dfs(x, y + 1);
        }

    }


    private boolean isBorder(int x, int y) {
        return x == 0 || x == isChecked.length - 1
                || y == 0 || y == isChecked[0].length - 1;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < isChecked.length && y >= 0 &&
                y < isChecked[0].length
                && !isChecked[x][y] && board[x][y] == 'O';
    }

}
