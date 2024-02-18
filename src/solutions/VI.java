package solutions;

public class VI {
//    public String convert(String s, int numRows) {
//        int len = s.length();
//        // two edge cases:
//        if (numRows == 1 || numRows > len){
//            return s;
//        }
//        List<String> strList = new ArrayList<>();
//        for (int i = 0; i < numRows; i++) {
//            strList.add("");
//        }
//
//        int idx = 0;
//        int zigIdx = 0;
//        boolean isInverse = false;
//        while (idx < len){
//            if (zigIdx == numRows){
//                isInverse = true;
//                zigIdx -= 2;
//            }
//            if (zigIdx == -1){
//                isInverse = false;
//                zigIdx += 2;
//            }
//            if (!isInverse){
//                strList.set(zigIdx, (strList.get(zigIdx) + (s.charAt(idx++))));
//                zigIdx++;
//            }
//            else{
//                strList.set(zigIdx, (strList.get(zigIdx) + (s.charAt(idx++))));
//                zigIdx--;
//            }
//        }
//        return String.join("", strList);
//    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder answer = new StringBuilder();
        int len = s.length();
        int diff = 2 * (numRows - 1);
        int diagonalDiff = diff;
        int secondIndex;
        int index;
        for (int i = 0; i < numRows; i++) {
            index = i;

            while (index < len) {
                answer.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    diagonalDiff = diff-2*i;
                    secondIndex = index + diagonalDiff;

                    if (secondIndex < len) {
                        answer.append(s.charAt(secondIndex));
                    }
                }
                index += diff;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        new VI().convert("PAYPALISHIRING", 3);
    }
}
