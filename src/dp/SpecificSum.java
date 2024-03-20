package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecificSum {
    // given a non-negative integer array, and a result, return a boolean that the result can be added from the integer array:
    // [1,2,3,4,5] and 7; true: 7 = 2+2+3; 7 = 2+5; 7 = 1+1+1+1+1+1+1
    // [2,4] and 7; false
    // note that 1 is meaningless in this question

    public boolean canSum(int res, int[] numList){
        if (res < 0) return false; // error condition
        if (res == 0) return true; // end condition

        for (int i = 0; i < numList.length; i++) {
            int remainder = numList[i];
            if (canSum(res-remainder, numList)){
                return true;
            }
        }
        return false;
    }

    // time: n^m, m is the length of arr, m is the result, space: n+m
    public boolean canSum(int res, int[] numList, Map<Integer, Boolean> memo){
        if (res < 0) return false; // error condition
        if (res == 0) return true; // end condition

        for (int element : memo.keySet()){
            if (res == element) return memo.get(res);
        }

        for (int i = 0; i < numList.length; i++) {
            int remainder = numList[i];
            int key = res - remainder;
            boolean value = canSum(res-remainder, numList, memo);
            memo.put(key, value);
            if (value){
                return true;
            }
        }
        memo.put(res, false);
        return false;
    }

    // time: n*m, m is the length of arr, m is the result, space: n+m

    public List<Integer> howSum(int res, int[] numList){
        if (res < 0) return null;
        if (res == 0) return new ArrayList<>();

        for (int i = 0; i < numList.length; i++) {
            int remainder = numList[i];
            List<Integer> list = howSum(res - remainder, numList);
            if (list != null) {
                list.add(remainder);
                return list;
            }
        }

        return null;
    }

    public List<Integer> howSum(int res, int[] numList, Map<Integer, List<Integer>> memo){
        if (res < 0) return null;
        if (res == 0) return new ArrayList<>();

        for (int element : memo.keySet()){
            if (element == res) return memo.get(element);
        }
        for (int i = 0; i < numList.length; i++) {
            int remainder = numList[i];
            List<Integer> list = howSum(res - remainder, numList, memo);
            if (list != null) {
                list.add(remainder);
                memo.put(res - remainder, list);
                return list;
            }
        }
        return null;
    }

    // return the shortest times of addition

    // store the value in shortest and transfer the value to list
    public List<Integer> bestSum(int res, int[] numList){

        List<Integer> shortest = new ArrayList<>();

        if (res < 0) return null;
        if (res == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < numList.length; i++) {
            int remainder = numList[i];
            List<Integer> list = bestSum(res - remainder, numList);
            if (list != null){
                list.add(remainder);
                if (shortest.size() == 0 || shortest.size() > list.size()){
                    shortest = list;
                }
            }


        }
        if (shortest.size() == 0) return null;
        return shortest;
    }

    public List<Integer> bestSum(int res, int[] numList, Map<Integer, List<Integer>> memo){

        for (int element : memo.keySet()) {
            if (element == res) return memo.get(res);
        }

        List<Integer> shortest = new ArrayList<>();



        if (res < 0) return null;
        if (res == 0) {
            return new ArrayList<>();
        }



        for (int i = 0; i < numList.length; i++) {
            int remainder = numList[i];
            List<Integer> tempList = bestSum(res - remainder, numList, memo); // shortest and tempList are the same class!

            if (tempList != null){
                List<Integer> list = new ArrayList<>();
                list.addAll(tempList);
                list.add(remainder);
                if (shortest.size() == 0 || shortest.size() > list.size()){
                    shortest = list;

                }
            }
        }
        if (shortest.size() == 0) return null;
        memo.put(res, shortest);
        return shortest;
    }






    public static void main(String[] args) {
        SpecificSum test = new SpecificSum();
        int[] arr = {2,3,6,7};
//        System.out.println(test.canSum(1000, arr));
//        System.out.println(test.howSum(300, arr));
        System.out.println(test.howSum(7, arr, new HashMap<>()));
        System.out.println(test.bestSum(100,arr, new HashMap<>()));


    }
}
