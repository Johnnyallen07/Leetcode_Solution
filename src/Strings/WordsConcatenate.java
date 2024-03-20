package Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordsConcatenate {
    /*
    leetcode 30
    Input: s = "barfoothefoobarman", words = ["foo","bar"]
    Output: [0,9]

    Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
    Output: [6,9,12]
     */

    String str;
    List<Integer> solutions;

//    public List<Integer> findSubstring(String s, String[] words) {
//        List<String> wordList = new ArrayList<>(Arrays.asList(words));
//
//
//    }

    // 17. Letter Combinations of a Phone Number
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        List<String> solution = new LinkedList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            String str = map.get(digit);
            if (solution.size() == 0){
                for (int j = 0; j < str.length(); j++) {
                    solution.add(Character.toString(str.charAt(j)));
                }
            }
            else {
                String remove = "";
                int size = solution.size();
                for (int j = 0; j < size; j++) {
                    remove = ((LinkedList<String>) solution).pop();
                    for (int k = 0; k < str.length(); k++) {
                        solution.add(remove + str.charAt(k));
                    }
                }


            }

        }
        return solution;
    }

    public static void main(String[] args) {
        WordsConcatenate test = new WordsConcatenate();
        System.out.println(test.letterCombinations("23"));

    }



    public List<Integer> findSubstring(String s, String[] words) {
        return null;
    }
}
