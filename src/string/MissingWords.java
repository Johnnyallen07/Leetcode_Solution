package string;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    // given two lists of words:
    // "I have pairs" "pairs" -> ["I","have"]
    // t must be subsequence of s
    public List<String> wordMatching(String s, String t) {
        List<String> strList_1 = this.splitText(s, ' ');
        List<String> strList_2 = this.splitText(t, ' ');
        List<String> ans = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < strList_2.size(); i++) {

            while (count < strList_1.size() && !(strList_1.get(count).equals(strList_2.get(i)))) {
                ans.add(strList_1.get(count));
                count++;
            }
            count++;
        }
        while (count < strList_1.size()){
            ans.add(strList_1.get(count++));
        }
        return ans;
    }

    private List<String> splitText(String s, char pattern) {
        StringBuilder string = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == pattern) {
                ans.add(string.toString());
                string = new StringBuilder();
            } else {
                string.append(s.charAt(i));
            }
        }
        string.append(s.charAt(s.length() - 1));
        ans.add(string.toString());
        return ans;

    }

    public static void main(String[] args) {
        MissingWords test = new MissingWords();
        System.out.println(test.wordMatching("Hello world", "world"));
        System.out.println(test.wordMatching("Python is a trash language", "trash"));
    }
}
