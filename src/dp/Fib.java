package dp;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    // recurrence formula: f(n) = f(n-1) + f(n-2) and f(0)=f(1)=1
    // only for small integer
    // time complexity 2^n, space n
    public int fib(int index){
        if (index <= 2) return 1;
        return fib(index - 1) + fib(index - 2);
    }

    public static void main(String[] args) {
        Fib test = new Fib();
        System.out.println(test.fib(8,new HashMap<>()));
    }

    // memorize the duplicate process: Map
    // time complexity n, space n
    public int fib(int index, Map<Integer, Integer> memo){
        for(int element : memo.keySet()){
            if (index == element) return memo.get(index);
        }
        if (index <= memo.size()) return memo.get(index);
        if (index <= 2) {
            return 1;
        }
        memo.put(index,fib(index-1, memo)+fib(index-2,memo));

        return memo.get(index);

    }
}
