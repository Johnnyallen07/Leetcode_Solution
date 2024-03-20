package dataStructure.queue;

import java.util.ArrayList;

// LeetCode 622
class MyCircularQueue{

    ArrayList<Integer> arr;
    int size;

    public MyCircularQueue(int k) {
        arr = new ArrayList<>();
        size = k;
    }

    public boolean enQueue(int value) {
        if(arr.size()<size){
            arr.add(0,value);
            return true;
        }else{
            return false;
        }
    }

    public boolean deQueue() {
        if(arr.size()>0){
            arr.remove(arr.size()-1);
            return true;
        }else{
            return false;
        }
    }

    public int Front() {
        if(arr.size()>0) return arr.get(arr.size()-1);
        else return -1;
    }

    public int Rear() {
        if(arr.size()>0) return arr.get(0);
        else return -1;
    }

    public boolean isEmpty() {
        if(arr.size()==0) return true;
        else return false;
    }

    public boolean isFull() {
        if(arr.size()==size) return true;
        else return false;
    }
}
