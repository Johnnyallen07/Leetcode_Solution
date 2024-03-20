package graphics;

public class MagicSquare {
    static int dim = 3;
    static final int sum = (1 + dim * dim) * dim / 2;

    public static void main(String[] args) {
        int[] numList = new int[dim*dim];
        for (int i = 1; i <= numList.length; i++) {
            numList[i-1] = i;
        }
        int[][] board = new int[dim][dim];
        recursiveCall(0,0,numList,board);
    }
    public static boolean isEnd(int[][] arr) {
        int current_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                current_sum += arr[i][j];
            }
            if (current_sum != sum) {
                return false;
            }
            current_sum = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                current_sum += arr[j][i];
            }
            if (current_sum != sum) {
                return false;
            }
            current_sum = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            current_sum += arr[i][i];
        }
        if (current_sum != sum) return false;
        current_sum = 0;

        for(int i = arr.length - 1; i >= 0; i--){
            current_sum += arr[i][i];
        }
        if (current_sum != sum) return false;

        return true;
    }

    public static int[] removeTheElement(int[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public static void print(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // return one solution
    public static boolean recursiveCall2(int x, int y, int[] numList, int[][] board){
        if (y == dim){
            x++;
            y = 0;
        }

        if (isEnd(board)){
            print(board);
            return true;
        }

        if (x < dim){
            for (int i = 0; i < numList.length; i++) {
                board[x][y] = numList[i];

                if (recursiveCall2(x, y+1, removeTheElement(numList, i), board)){

                    return true;
                }
                board[x][y] = -100;
            }
        }
        return false;
    }

    public static void recursiveCall(int x, int y, int[] numList, int[][] board){
        if (y == dim){
            x++;
            y = 0;
        }

        if(isEnd(board)){
            print(board);
        }

        if (x < dim){
            for (int i = 0; i < numList.length; i++) {
                board[x][y] = numList[i];

                recursiveCall(x, y+1, removeTheElement(numList, i), board);
                board[x][y] = -100;
            }
        }
    }
}
