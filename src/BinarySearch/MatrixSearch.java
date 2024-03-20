package BinarySearch;

public class MatrixSearch {
    public static void main(String[] args) {
        MatrixSearch test = new MatrixSearch();
        int[][] matrix = {{1,3}};
        int target = 1;
        System.out.println(test.searchMatrix(matrix, target));

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        return binarySearch(0, (row * col - 1) / 2, row * col - 1, matrix, target);

    }

    public boolean binarySearch(int low, int mid, int high, int[][] matrix, int target){
        int row = mid/matrix[0].length;
        int col = (mid%matrix[0].length);
        if (mid >= high && target != matrix[row][col]){
            return false;
        }
        if (matrix[row][col] < target){
            return binarySearch(mid + 1, (mid + high + 1) / 2, high, matrix, target);
        }
        else if (matrix[row][col] > target){
            return binarySearch(0, (mid - 1) / 2, mid - 1, matrix, target);
        }
        else return true;
    }

}
