package rummikub;

import java.util.List;

public class Generator {
    public void addSeq(List<String> list, String color, int start, int end){
        for (int i = start; i < end ; i++) {
            list.add(color+i);
        }
    }

    public void addSame(List<String> list, int num, int len, int seed){
        if (len == 4){
            list.add("A"+num);
            list.add("B"+num);
            list.add("C"+num);
            list.add("D"+num);
        }
        if (len == 3){
            List<String> color_set = Utils.getPermutation(4,3,seed);
            for (int i = 0; i < color_set.size(); i++) {
                list.add(color_set.get(i)+num);
            }
        }
    }
}
