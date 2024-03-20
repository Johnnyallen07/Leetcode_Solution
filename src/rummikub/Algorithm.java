package rummikub;

import java.util.List;
import java.util.Stack;

public class Algorithm {

    public InsertRule rule = new InsertRule();


    public boolean isEnd(Stack<String> list){
        for (int i = 0; i < list.size(); i++) {
            if(dp(list)){
                return true;
            }
            list.add(list.pop());
        }
        return false;
    }



    public boolean dp(List<String> list){
        if (list.size() < 3){
            return false;
        }
        int num = 13;
        if (list.size() <= 13){
            num = list.size();
        }

        for (int i = 3; i <= num; i++) {
            List<String> seqList = rule.seq(list, i);

            if (seqList != null) {
                List<String> str = Utils.deepcopy(seqList);
                Utils.removeAll(list, seqList);
                if (list.size() == 0){
                    return true;
                }

                if (dp(list)) {
                    return true;
                } else {
                    list.addAll(str);
                }
            }

            for (int j = 3; j <= 4; j++) {
                for (int k = 1; k <= 24; k++) {
                    List<String> sameList = rule.same(list, j, k);
                    if (sameList != null) {
                        List<String> str = Utils.deepcopy(sameList);
                        Utils.removeAll(list,sameList);
                        if (list.size() == 0){
                            return true;
                        }
                        if (dp(list)) {
                            return true;
                        } else {
                            list.addAll(str);
                        }
                    }

                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Stack<String> list = new Stack<>();

        Algorithm test = new Algorithm();
        Generator gen = new Generator();
        gen.addSame(list, 11, 4, 2);
        gen.addSame(list, 12, 3, 1);
        gen.addSeq(list, "B",  7, 12);
        gen.addSeq(list, "C", 9, 13);
        gen.addSeq(list, "A", 1, 5);
        System.out.println(test.isEnd(list));
    }

}
