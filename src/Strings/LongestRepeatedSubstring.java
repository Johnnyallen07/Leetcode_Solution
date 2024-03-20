package Strings;

public class LongestRepeatedSubstring {
    public static final int R = 255;
    // apply MSD sort and Prefix array
    private static int charAt(String s, int d){
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a){
        String[] aux =  new String[a.length];
        sort(a,aux,0,a.length-1,0);
    }

    private static void sort(String[] a, String[] aux, int lo, int hi, int d){
        if (hi <= lo) return;
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d)+2]++;
        }
        for (int r = 0; r < R+1; r++) {
            count[r+1]+=count[r];
        }
        for (int i = lo; i <= hi; i++){
            aux[count[charAt(a[i],d)+1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++){
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
            sort(a, aux, lo+count[r], lo + count[r+1]-1, d+1);
        }
    }

    public String lrs(String s){
        int N = s.length();

        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }

        sort(suffixes);

        String lrs = "";
        for (int i = 0; i < N-1; i++) {
            int len = lcp(suffixes[i], suffixes[i+1]);
            if (len > lrs.length()) {
                lrs = suffixes[i].substring(0, len);
            }

        }
        return lrs;
    }

    private static int lcp(String a, String b){
        int count = 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
            else return count;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestRepeatedSubstring tst = new LongestRepeatedSubstring();
        String ans = tst.lrs("banana");
        System.out.println(ans);
    }

}
