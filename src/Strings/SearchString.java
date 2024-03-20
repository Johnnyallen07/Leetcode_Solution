package Strings;

public class SearchString {

    public static final int R = 255;
    public int strStr(String haystack, String needle) {
        return search(haystack, needle);
    }

    private static int[][] KMP(String pat){
        int M = pat.length();
        int[][] dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int i = 0; i < R; i++) {
                dfa[i][j] = dfa[i][X];
            }
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
        return dfa;
    }

    public int search(String txt, String pat){
        int i,j,N = txt.length();
        int M = pat.length();
        for (i=0,j=0; i<N&&j<M;i++) {
            int[][] dfa = KMP(pat);
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i-M;
        else return N;
    }
}
