package graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> str = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            str.add(Arrays.asList(temp));
        }

        // fill all values to 1

        for (int i = 2; i < numRows; i++) {
            for (int j = 2; j < str.get(i).size(); j++) {
                List<Integer> row = str.get(i);
                row.set(j-1, str.get(i - 1).get(j - 2) + str.get(i - 1).get(j-1));
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Pascal pascal = new Pascal();
        pascal.generate(3);
    }
}
