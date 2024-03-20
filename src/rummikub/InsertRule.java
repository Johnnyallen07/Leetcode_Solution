package rummikub;

import java.util.ArrayList;
import java.util.List;


public class InsertRule {


    // return a sequence of number (from the least number):
    // B1 B2 B3 B4 B5 with length 5
    public List<String> seq(List<String> list, int len){
        if (len < 3 || len > 13){
            throw new ArithmeticException(
                    "Sequence must be larger than 3 and less than 13");
        }
        if (len > list.size()){
            return null;
        }
        ArrayList<String> str = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (str.size() == len){
                return str;
            }
            int index = Integer.parseInt(
                    list.get(i).substring(1));
            char color = list.get(i).charAt(0);
            if (index > 11){
                continue;
            }
            for (int j = 0; j < len; j++) {
                String card = color + Integer.toString(index + j);
                if (!list.contains(card)){
                    str = new ArrayList<>();
                    break;
                }
                str.add(card);
            }

        }
        return null;

    }

    // same rule has a permutation problem: A1 B1 C1 D1 and take three of them
    public List<String> same(List<String> list, int len, int seed){
        if (len < 3 || len > 4){
            throw new ArithmeticException(
                    "length must be larger than 3 and " +
                            "less than 5");
        }
        ArrayList<String> str = new ArrayList<>();
        List<String> color_set = Utils.getPermutation(4,len,seed);

        for (int i = 0; i < list.size(); i++) {
            if (str.size() == len){
                return str;
            }
            int index = Integer.parseInt(
                    list.get(i).substring(1));
            for (int j = 0; j < len; j++) {
                String card = color_set.get(j) + index;
                if (!list.contains(card)){
                    str = new ArrayList<>();
                    break;
                }
                str.add(card);
            }

        }
        return null;


    }

    // P_n^m in kth position



    // return two colors from three colors by given seed




    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A2");
        list.add("A3");
        list.add("A4");
        list.add("A5");
        list.add("A6");


        list.add("A4");
        list.add("B4");
        list.add("C4");

        InsertRule test = new InsertRule();

        List<String> seq = test.seq(list, 5);
        System.out.print(seq);

        System.out.println(list);
//        for (int i = 1; i <= 12; i++) {
//            System.out.println(test.same(list,3,i));
//        }

//        String str = "B8";
//        System.out.println(test.swap(str, 1));
    }
}
