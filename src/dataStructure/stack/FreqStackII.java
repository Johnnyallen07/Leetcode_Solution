package dataStructure.stack;

import java.util.HashMap;
import java.util.Stack;


// given a frequency map and a stack map,
// record the sequence of max frequency in stack map (FIFO)

public class FreqStackII {
    HashMap<Integer, Stack> st=new HashMap<>();
    HashMap<Integer,Integer> fmap=new HashMap<>();
    int maxfreq=0;
    public void push(int val) {
        int cfreq=fmap.getOrDefault(val,0);
        cfreq++;
        fmap.put(val,cfreq);
        if(st.containsKey(cfreq)==false)
        {
            st.put(cfreq,new Stack<>());
        }
        st.get(cfreq).add(val);
        maxfreq=Math.max(cfreq,maxfreq);

    }

    public int pop() {
        Stack<Integer> s= st.get(maxfreq);
        int ans=s.pop();
        int cfreq=fmap.get(ans);
        cfreq--;
        fmap.put(ans,cfreq);
        if(st.get(maxfreq).size()==0)
            maxfreq--;

        return ans;
    }

    public static void main(String[] args) {
        FreqStackII test = new FreqStackII();
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
