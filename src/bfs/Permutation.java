package bfs;
import java.util.ArrayList;
import java.util.List;

public class Permutation {

    // given distinct numbers
    public static void main(String[] args) {
        Permutation test = new Permutation();
        int[] arr = {1,2};
        System.out.println(test.permute(arr));
    }
    List<List<Integer>> solution = new ArrayList<>();
    int index = 0;
    public List<List<Integer>> permute(int[] nums) {
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


    }
}
