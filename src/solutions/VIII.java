package solutions;

public class VIII {
    public int myAtoi(String s) {
        boolean isNeg = false;
        int num = 0;
        boolean isMax = false;
        boolean isRecord = false;
        int flag = Integer.MAX_VALUE / 10;
        int idx = 0;
        while (idx < s.length()){
            if (s.charAt(idx) != ' '){
                break;
            }
            idx++;
        }
        for (int i = idx; i < s.length() ; i++) {
            char letter = s.charAt(i);
            if ((letter != '-' && letter != '+'
                    && !isDigit(letter))){
                if (isMax){
                    return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                return isNeg? -num : num;
            }
            if (letter == '-' || letter == '+'){
                if (isRecord){
                    return num;
                }
                if (i < s.length() - 1 && isDigit(s.charAt(i + 1))){
                    isNeg = letter == '-';
                }
                else{
                    return 0;
                }
            }
            if (isDigit(letter)){
                isRecord = true;
                if (num < flag){
                    num = num * 10 + (letter - '0');
                }
                else if (num == flag){
                    if ((letter - '0') < 8){
                        num = num * 10 + (letter - '0');
                    }
                    else{
                        isMax = true;
                    }
                }
                else{
                    isMax = true;
                }
            }
        }
        if (isMax){
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return isNeg? -num : num;
    }

    private boolean isDigit(char letter){
        return (letter - '0' >= 0) && (letter - '9' <= 9);
    }

    public static void main(String[] args) {
        System.out.println(new VIII().myAtoi("      -11919730356x"));
    }
}
