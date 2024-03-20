package dataStructure.stack;

import java.util.Stack;

public class ValidateStack {


    // LeetCode 946
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // use a stack to judge the validate sequence
        Stack<Integer> push = new Stack<>();
        int push_idx = 0;
        int pop_idx = 0;

        while (push_idx < pushed.length || pop_idx < popped.length) {
            if (push_idx == pushed.length && popped[pop_idx] != push.peek()) {
                return false;
            }
            if (push.isEmpty()){
                push.push(pushed[push_idx++]);
            }
            // first while loop takes push
            while (push_idx < pushed.length) {

                if (popped[pop_idx] != push.peek()) push.push(pushed[push_idx++]);
                else break;

            }
            // this one judges the pop
            while (pop_idx < popped.length && !push.isEmpty()) {
                if (popped[pop_idx] == push.peek()){
                    push.pop();
                    pop_idx++;
                }
                else break;

            }

        }
        return true;
    }

    public static void main(String[] args) {
        ValidateStack test = new ValidateStack();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 3, 2, 1};
        test.validateStackSequences(arr1, arr2);
    }

    // optimization of space O(N) -> O(1)
    public boolean validateStackSequencesII(int[] pushed, int[] popped) {
        Stack<Integer> push = new Stack<>(); // Create a stack

        int j = 0; // Intialise one pointer pointing on popped array

        for(int val : pushed){
            push.push(val); // insert the values in stack
            while(!push.isEmpty() && push.peek() == popped[j]){ // if st.peek() values equal to popped[j];
                push.pop(); // then pop out
                j++; // increment j
            }
        }
        return push.isEmpty(); // check if stack is empty return true else false
    }
}
