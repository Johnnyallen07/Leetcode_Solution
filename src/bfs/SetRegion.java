package bfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SetRegion {
    public final int write = 0xFFFFFF;
    public final int black = 0;
    int count = 1;
    int[][] matrix = new int[32][32];

    public int[][] fileInput(String filePath){
        int[] arr = new int[1024];
        int count = 0;
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arr[count++] = Integer.valueOf(color(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                matrix[i][j] = arr[i + 32 * j];
            }
        }
        return matrix;
    }

    public String color(String data){
        for (int i = data.length() - 1; i >= 0; i--) {
            if (data.charAt(i) == ' '){
                return data.substring(i + 1);
            }
        }
        return null;
    }

    public void format(){
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SetRegion test = new SetRegion();
        test.fileInput("C:\\Desktop\\test\\Tile128-1-7-7.txt");
        test.solution();
        // test.format();
        System.out.println("The number of region: " + test.regionNum());
        System.out.println("The maximum region: " + test.maxArea());
        System.out.println("The minimum region: " + test.minArea());


    }

    public void solution (){
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (matrix[i][j] == black){
                    bfs(i, j);
                    count++;
                }
            }
        }
    }

    public void bfs(int row, int col){
        matrix[row][col] = count; // set region
        if (row > 0 && col > 0 && matrix[row - 1][col - 1] == black){
            bfs(row - 1, col - 1); // left up
        } // test correct
        if (row > 0 && matrix[row - 1][col] == black){
            bfs(row - 1, col); // up
        }
        if (row > 0 && col < 31 && matrix[row - 1][col + 1] == black){
            bfs(row - 1, col + 1); // right up
        }
        if (col > 0 && matrix[row][col - 1] == black){
            bfs(row, col - 1); // left
        }
        if (col < 31 && matrix[row][col + 1] == black){
            bfs(row, col + 1); // right
        }
        if (row < 31 && col > 0 && matrix[row + 1][col - 1] == black){
            bfs(row + 1, col - 1); // left down
        }
        if (row < 31 && matrix[row + 1][col] == black){
            bfs(row + 1, col); // down
        }
        if (row < 31 && col < 31 && matrix[row + 1][col + 1] == black){
            bfs(row + 1, col + 1);
        }
    }

    public int regionNum(){ // The number of Region
        return count - 1;
    }

    public int area(int num){ // Return area of special region
        // this method could be optimized in bfs method
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (matrix[i][j] == num){
                    result++;
                }
            }
        }
        return result;
    }

    public int maxArea(){
        int maxArea = 0;
        for (int i = 1; i <= regionNum(); i++) {
            if (maxArea < area(i)){
                maxArea = area(i);
            }

        }
        return maxArea;
    }

    public int minArea(){
        int minArea = area(1);
        for (int i = 1; i <= regionNum(); i++) {
            if (minArea > area(i)){
                minArea = area(i);
            }

        }
        return minArea;
    }



}
