package solutions;

import java.util.HashSet;
import java.util.Set;

public class III {
    public int lengthOfLongestSubstring(String s) { // classic two pointer approach
        Set<Character> charList = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            if (!charList.contains(s.charAt(right))) {
                charList.add(s.charAt(right));


            } else {
                maxLength = Math.max(maxLength, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    charList.remove(s.charAt(left));
                    left++;
                }
                charList.remove(s.charAt(left));
                left++;
                charList.add(s.charAt(right));
            }
            maxLength = Math.max(maxLength, s.length() - left);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new III().lengthOfLongestSubstring("dvdf"));
    }
}
