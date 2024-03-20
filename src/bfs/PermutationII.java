package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationII {
    // given any number: leetcode 47

    HashSet<ArrayList<Integer>> result = new HashSet<>();
    int index = 0;

    public List<List<Integer>> permute(int[] nums) {
        boolean[] table = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        bfs(nums, table, list);
        return new ArrayList<>(result);
    }

    public void bfs(int[] nums, boolean[] table, List<Integer> list) {
        for (int i = 0; i < nums.length; i++) {
            if (!table[i]) {
                list.add(nums[i]);
                table[i] = true;
                index++;
                bfs(nums, table, list);
                index--;
                table[i] = false;
                list.remove(list.size() - 1);
            }
        }

        if (index == nums.length) {

            result.add(new ArrayList<>(list));
        }
    }

    public static void main(String[] args) {
        PermutationII test = new PermutationII();
        int[] arr = {1,1,2,2};
        System.out.println(test.permute(arr));
    }
}