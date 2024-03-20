package Strings;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    // Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    // Output: ["cats and dog","cat sand dog"]
    // use dfs to solve the problem

    String str = "";
    List<String> solution = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, wordDict);
        return solution;
    }

    public boolean dfs(String s, List<String> wordDict){

        if (s.equals("") && str != null){
            solution.add(str);
            return true;
        } // end condition

        for (int i = 0; i < wordDict.size(); i++) {
            if(subString(s,wordDict.get(i))) {
                str = str + wordDict.get(i) + " ";
                s = s.substring(wordDict.get(i).length());
                dfs(s, wordDict);
                str = str.substring(0,str.length()-wordDict.get(i).length()-1); // back
                s = wordDict.get(i) + s;
            }
        }
        return false;

    }

    public boolean subString(String str, String subStr){
        char[] subList = subStr.toCharArray();
        char[] strList = str.toCharArray();

        if(subList.length > strList.length) return false;
        for (int i = 0; i < subList.length; i++) {
            if (subList[i] != strList[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        test.wordBreak(s, wordDict);
    }

}
