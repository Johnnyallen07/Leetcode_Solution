package bfs;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {



    // brute force:


    /*

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        int[] arr = {1,2};
        System.out.println(test.getPermutation(2,2));
    }

    List<List<Integer>> solution = new ArrayList<>();
    int index = 0;

    public String getPermutation(int n, int k) {
        permute(n);
        List result;
        result = solution.get(k-1);
        String str = "";
        for (int i = 0; i < n ; i++) {
            str = str + result.get(i);
        }
        return str;
    }

    public List<List<Integer>> permute(int num) {
        int[] nums = new int[num];
        for (int i = 1; i <= num; i++) {
            nums[i - 1] = i;
        }
        boolean[] table = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        bfs(nums, table, list);
        return solution;
    }

    public void bfs(int[] nums, boolean[] table, List<Integer> list){
        for (int i = 0; i < nums.length; i++) {
            if(!table[i]){
                list.add(nums[i]);
                table[i] = true;
                index++;
                bfs(nums, table, list);
                index--;
                table[i] = false;
                list.remove(list.size()-1);
            }
        }

        if (index == nums.length){

            solution.add(new ArrayList<>(list));
        }
     */

    // get sequence from mathematical approach:
    // 1,1,2,6,24,120,...
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }


}
