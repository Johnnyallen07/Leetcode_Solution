package string;

import java.util.ArrayList;
import java.util.List;

// 6
public class ZigZag {
    public String convert(String s, int numRows) {
        String res = "";
        int idx = 0;
        while (idx < s.length()) {
            for (int i = 0; i < (numRows - 1); i++) {
                if (idx >= s.length()) {
                    break;
                }
                res += (s.charAt(idx));
                res += (s.charAt(idx + numRows - i));
                idx++;
            }
            idx = idx + numRows - 1;
        }
        return res;

    }
}
