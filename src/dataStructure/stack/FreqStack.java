package dataStructure.stack;

import java.util.*;

// brute force, LeetCode 895,

class FreqStack {
    HashMap<Integer, Integer> dic = new HashMap<>();


    int size = 8;
    int count = 0;
    int[] stack = new int[size];

    public FreqStack() {

    }

    public void push(int val) {
        // check the capacity of the array;
        if (count == size) {
            int[] temp = new int[2 * size];
            for (int i = 0; i < size; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
            size *= 2;
        }
        stack[count++] = val;
        if (!dic.containsKey(val)) {
            dic.put(val, 1);
        } else {
            dic.put(val, dic.get(val) + 1);
        }

    }

    public int pop() {
        int max_count = 0;
        Collection<Integer> values = dic.values();
        List<Integer> max = new ArrayList<>();
        for (int value : values) {
            if (max_count < value) {
                max_count = value;
            }
        }
        Set<Integer> keys = dic.keySet();
        for (int key : keys) {
            if (dic.get(key) == max_count) {
                max.add(key);
            }
        }

        int num = count;
        int ans = -1;
        while (num > 0){
            if(max.contains(stack[--num])){
                ans = stack[num];
                break;
            }
        }

        // rearrange the array
        for (int i = num+1; i < count; i++) {
            stack[i-1] = stack[i];
        }
        stack[--count] = 0;



        // optimise: delete the key if value is 0:
        if (dic.get(ans)-1==0){
            dic.remove(ans);
        }
        else{
            // rearrange the dic
            dic.put(ans, dic.get(ans)-1);
        }

        return ans;

    }

    public static void main(String[] args) {
        FreqStack test = new FreqStack();
        test.push(1);
        test.push(2);
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
