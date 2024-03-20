package Strings;

public class ValidParenthese {
    // LeetCode 32
    public int longestValidParentheses(String s) {
        char[] charList = s.toCharArray();
        int res = 0, left = 0, right = 0, n = charList.length;
        for (int i = 0; i < n; ++i) {
            if (charList[i] == '(') {
                ++left;
            } else ++right;
            if (left == right) {
                res = Math.max(res, 2 * right);
            } else if (right > left) left = right = 0;
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (charList[i] == '(') {
                ++left;
            } else ++right;
            if (left == right) {
                res = Math.max(res, 2 * left);
            } else if (left > right) left = right = 0;
        }
        return res;
    }
}
