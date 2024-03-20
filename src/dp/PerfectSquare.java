package dp;

public class PerfectSquare {
    int count = 0;
    int least_num = Integer.MAX_VALUE;
    // 279
    public static void main(String[] args) {
        PerfectSquare test = new PerfectSquare();
        System.out.println(test.numSquares(13));
    }

    public int numSquares(int n) {

        if (n == 0){
            return count;
        }


        int largest_square = (int)(Math.sqrt(n));
        for (int i = 1; i <= largest_square; i++) {
            count++;
            int num = numSquares(n - i*i);
            count = 0;

            if (num < least_num){
                least_num = num;
                System.out.println(least_num);

            }



            }
        return least_num;
    }
}
