package Strings;

public class RegularMatch {
    /*
    Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

    Input: s = "ab", p = ".*"
    Output: true

    "aab" "a*b*c" true

     */

    public boolean isMatch(String s, String p) {
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int i, int j){

        if (j == p.length()){
            return i == s.length();
        }

        boolean isFirstLetter = false;

        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            isFirstLetter = true;
        }

        if (j < p.length() - 1 && p.charAt(j+1) == '*'){

            return dp(s, p, i, j + 2) || (isFirstLetter && dp(s, p, i + 1, j)); /* '*' is zero */
        }
        else if (isFirstLetter){
            return dp(s, p, i+1, j+1);
        }
        return false;
    }



    public static void main(String[] args) {
        RegularMatch test = new RegularMatch();
        System.out.println(test.isMatch("ab", ".*c"));
    }


}
