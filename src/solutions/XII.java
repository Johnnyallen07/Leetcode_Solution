package solutions;

import java.util.HashMap;
import java.util.Map;

// 12
public class XII {

    public static void main(String[] args) {
        System.out.println(new XII().intToRoman(113));
    }
    private static final Map<Integer, Character> dict = new HashMap<>();

    static{
        dict.put(1, 'I');
        dict.put(5, 'V');
        dict.put(10, 'X');
        dict.put(50, 'L');
        dict.put(100, 'C');
        dict.put(500, 'D');
        dict.put(1000, 'M');
    }

    public String intToRoman(int num) {
        int digit = String.valueOf(num).length();
        int len = digit;
        String numStr = String.valueOf(num);
        StringBuilder roman = new StringBuilder();
        while (digit != 0){

            int digitAt = (numStr.charAt(len - digit) - '0');
            int unit =  (int) Math.pow(10, digit-1);
            if (digitAt < 4){
                for (int i = 0; i < digitAt; i++) {
                    roman.append(dict.get(unit));
                }
            }
            else if (digitAt == 4){
                roman.append(dict.get(unit));
                roman.append(dict.get(5*unit));
            }
            else if (digitAt < 9){
                roman.append(dict.get(5 * unit));
                for (int i = 0; i < digitAt - 5; i++) {
                    roman.append(dict.get(unit));
                }

            }
            else{
                roman.append(dict.get(unit));
                roman.append(dict.get((int) Math.pow(10, digit)));
            }
            digit--;

        }
        return roman.toString();
    }


}
