package Strings;

public class KMPalgorithm {
    // reduce the storage by compression:
    public int search(String haystack, String needle){
        int[] lps = new int[needle.length()];
        int pre = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (pre > 0 && needle.charAt(i) != needle.charAt(pre)){
                pre = lps[pre - 1];
            }
            if (needle.charAt(pre) == needle.charAt(i)){
                pre+=1;
                lps[i] = pre;
            }
        }

        int idx = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (idx > 0 && needle.charAt(idx)
                    != haystack.charAt(i)){
                idx = lps[idx - 1];
            }
            if (needle.charAt(idx) == haystack.charAt(i)){
                idx++;
            }
            if (idx == needle.length()) return i - idx + 1;
        }
        return -1;
    }
}
