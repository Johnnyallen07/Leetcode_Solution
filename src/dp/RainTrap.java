package dp;

public class RainTrap {
    // leetcode 42:

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int solution = 0;
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] >= height[i+1]) left[i+1] = left[i];/*Math.max(left[i], height[i])
           */
            else left[i+1] = Math.max(height[i+1], left[i]);
        }
        for (int i = height.length - 1; i > 0 ; i--) {
            if (height[i-1] < height[i]) right[i-1] = right[i];/* Math.max(right[i], height[i]);*/
            else right[i-1] = Math.max(height[i-1], right[i]);
        }
        for (int i = 0; i < height.length; i++) {
            solution = solution + (Math.min(left[i], right[i]) - height[i]);
        }
        return solution;
    }

    public static void main(String[] args) {
        RainTrap test = new RainTrap();
        int[] arr = {4,2,0,3,2,5};
        test.trap(arr);
    }
}
