package dataStructure.stack;

// LeetCode 155

// dynamic array or doubly-linked list could implement
public class MinStack {
    int size = 8;
    int min = Integer.MAX_VALUE;
    int[] stack = new int[size];
    int count = 0;

    public MinStack() {


    }

    public void push(int val) {
        // check the capacity of the array;
        if (count == size){
            int[] temp = new int[2*size];
            for (int i = 0; i < size; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
            size *= 2;
        }
        stack[count++] = val;
        // record minimum each time
        if (min > val){
            min = val;
        }
    }

    public void pop() {
        if (count == 0) {
            return;
        }
        // Update min if the element being popped
        // is the current minimum
        if (stack[--count] == min) {
            // Find the new minimum in the stack
            min = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                if (stack[i] < min) {
                    min = stack[i];
                }
            }
        }
    }

    public int top() {
        if (count > 0){
            return stack[count-1];
        }
        return -1;

    }

    public int getMin() {
        return min;
    }
}
