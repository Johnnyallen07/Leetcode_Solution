package graphics;

public class TwoCircles {

    static int count = 0;
    public static void main(String[] args) {
        int[] numList = {2,3,4,5,6,7,9};
        int[][] board = {{-100,-100,-100},{-100,-100,-100}};
        recursiveCall(0,0,numList,board);
        System.out.println("The total number of solutions: " + count);
    }

    // Function to remove the element
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

    public static boolean isEnd(int[][] arr){
        if ((arr[0][0] + arr[0][1] + arr[1][0] + arr[1][1] == 20) &&
        (arr[0][1] + arr[0][2] + arr[1][1] + arr[1][2] == 20)){
            count++;
            return true;
        }
        return false;
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



    public static void recursiveCall(int x, int y, int[] numList, int[][] board){
        if (y == 3){
            y = 0;
            x++;
        }

        if (isEnd(board)){
            print(board);
        }


        if (x < 2){
            for (int i = 0; i < numList.length; i++) {
                board[x][y] = numList[i];

                recursiveCall(x, y+1, removeTheElement(numList, i), board);
                board[x][y] = -100;
            }
        }

    }
}
