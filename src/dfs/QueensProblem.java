package dfs;

import java.util.ArrayList;
import java.util.List;

public class QueensProblem{
    boolean[][] position;

    int index = 0;
    List<List<String>> storage = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int index = 0;

        position = new boolean[n][n];

        dfs(0);

        return storage;
    }

    public boolean isSafe(int row, int column){
        int length = position.length;
        int x = row;
        int y = column;
        for (int j = 0; j < length; j++) {
            if (position[row][j] || position[j][column]){
                return false;
            } //check row and column
        }

        while (0 < x && 0 < y){
            if (position[--x][--y]) return false;
        } // left up diagonal

        x = row;
        y = column;
        while (x < length - 1 && y < length - 1){
            if (position[++x][++y]) return false;
        } // right down

        x = row;
        y = column;

        while (0 < x && y < length - 1){
            if(position[--x][++y]) return false;
        } // left down

        x = row;
        y = column;

        while (x < length - 1 && y > 0){
            if(position[++x][--y]) return false;
        } // right down
        return true;
    }


    public boolean dfs(int column){



        int length = position.length;

        // terminal condition:
        if (column >= length){
            storage.add(insert(position));
            return true;
        }


        // iterate row, column from 1 to n
        for (int i = 0; i < length; i++) {
            if(isSafe(i,column)) {
                position[i][column] = true;
                dfs(column+1);
                position[i][column] = false; // backtrack
            }
        }

        return false;
    }

    List<String> insert(boolean[][] position){

        List<String> ans = new ArrayList<>();
        for(boolean[] row: position){
            String S = "";
            for(boolean element:row){
                if(element){
                    S += "Q";
                }
                else
                    S += ".";
            }
            ans.add(S);
        }
        return ans;
    }

    public static void main(String[] args) {
        QueensProblem test = new QueensProblem();
        List<List<String>> lists = test.solveNQueens(5);
        System.out.println(lists);


    }

}
