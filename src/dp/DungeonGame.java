package dp;

public class DungeonGame {
    // leetcode 174
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = new int[row][col];

        // recurrence formula: dp[i][j] = min (dp[i-1][j], dp[i][j-1]) + num,
        // change the positive to the minimum negative.

        dp[0][0] = dungeon[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + dungeon[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + dungeon[i][0];
        }
        for (int i = 1; i < row ; i++) {
            for (int j = 1; j < col ; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + dungeon[i][j];
            }
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = Math.min(dp[0][i], dp[0][i -1]);
        }
        for (int i = 1; i < row ; i++) {
            dp[i][0] = Math.min(dp[i][0],dp[i-1][0]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (dp[i][j] > 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }



        return dp[row -1][col - 1];

    }

    public static void main(String[] args) {
        DungeonGame test = new DungeonGame();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        test.calculateMinimumHP(arr);
    }
}
