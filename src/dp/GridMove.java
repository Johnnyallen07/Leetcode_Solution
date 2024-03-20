package dp;

import java.util.HashMap;
import java.util.Map;


public class GridMove {
    // given the grid from 1 to n, and the ways from (1,1) to (n,n) downward or right only

    // end condition: grid (i, 0) = 0, grid (0, j) = 0, and grid (1,1) = 1

    // recurrence formula: f(m,n) = f(m-1.n) + f(m,n-1)

    public int gridTravel(int row, int col){


        if (row == 1 && col == 1) return 1;
        if (row == 0 || col == 0) return 0;
        return gridTravel(row-1, col) + gridTravel(row, col-1);
    }

    // key is row,column, and f(m,n) equals to f(n,m)

    // 2^{m+n}, space m+n
    public int gridTravel(int row, int col, Map<String,Integer> memo){


        for(String element : memo.keySet()){
            if ((row + "," + col).equals(element) || (col + "," + row).equals(element)) {
                if (memo.get((row + "," + col)) != null) return memo.get((row + "," + col));
                return memo.get((col + "," + row));
            };
        }

        if (row == 1 && col == 1) return 1;
        if (row == 0 || col == 0) return 0;

        String key = row + "," + col;
        int value = gridTravel(row-1, col, memo) + gridTravel(row, col-1, memo);
        memo.put(key, value);
        return value;

    }


    // m*n and space: m+n



    public static void main(String[] args) {
        GridMove test = new GridMove();
        System.out.println(test.gridTravel(16,16));
        System.out.println(test.gridTravel(16,16,new HashMap<>()));


    }
}
