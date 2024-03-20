package BinarySearch;

public class MatrixSearchII {

    public static void main(String[] args) {
        MatrixSearchII test = new MatrixSearchII();
        int[] arr = {1,3,5,6,7,9,10};
        System.out.println(test.BinarySearch(0, arr.length / 2, arr.length, arr, 4));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) { // check row:
            if (matrix[i][0] < target && matrix[i][col-1] > target){
                if (BinarySearch(0, (col - 1)/ 2, col - 1, matrix[i], target)){
                    return true;
                }
            }
            else if (matrix[i][0] == target || matrix[i][col - 1] == target){
                return true;
            }
        }
        return false;
    }
    public boolean BinarySearch(int low, int mid, int high, int[] arr, int target){
        if (mid >= high && arr[mid] != target) {
            return false;
        }

        if (arr[mid] < target){
            return BinarySearch(mid + 1, (mid + 1 + high) / 2, high, arr, target);
        }
        else if (arr[mid] > target){
            return BinarySearch(0, (mid - 1) / 2, mid - 1, arr, target);
        }
        else {
            return true;
        }
    }
}
