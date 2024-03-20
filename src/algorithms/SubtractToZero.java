package algorithms;

public class SubtractToZero {
    // [3,3,5,2,3], start from leftmost:
    // [0,0,2,2,3] -> [0,0,0,0,1] -> [0,0,0,0,0]
    // need 3+2+1 =6 numbers

    public int subtractList(int[] list) {
        int idx = 0;
        int len = list.length;
        int ans = 0;
        int least_num = list[0];
        for (int i = 0; i < len; i++) {
            idx = i;
            least_num = list[i];
            if (least_num > 0){
                while (idx < len && list[idx] >= least_num) {
                    list[idx] = list[idx] - least_num;
                    idx++;
                }
                ans += least_num;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,5,0,0,2,8,9};
        SubtractToZero test = new SubtractToZero();
        System.out.println(test.subtractList(arr));
    }
}
