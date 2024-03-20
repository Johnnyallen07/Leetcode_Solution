package rummikub;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    // remain repeated element:
    // list: [A1, A1, A2]; removed: [A1] ==> [A1,A2]
    public static void removeAll(List<String> list, List<String> removed_list){
        while(removed_list.size() > 0) {
            list.remove(removed_list.get(0));
            removed_list.remove(0);
        }
    }
    public static List<String> getPermutation(int n, int m,int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        k--;

        while (true) {
            ans.add(Integer.toString(nums.get(k / fact)));
            nums.remove(k / fact);

            if (nums.size()==n-m) {
                break;
            }

            k %= fact;
            fact /= nums.size();
        }
        for (int i = 0; i < ans.size(); i++) {
            switch (ans.get(i)) {
                case "1" -> ans.set(i, "A");
                case "2" -> ans.set(i, "B");
                case "3" -> ans.set(i, "C");
                case "4" -> ans.set(i, "D");
            }
        }

        return ans;
    }

    public static List<String> deepcopy(List<String> list){
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            str.add(list.get(i));
        }
        return str;
    }
}
