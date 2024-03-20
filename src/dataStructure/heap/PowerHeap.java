package dataStructure.heap;

import java.util.ArrayList;

// Walmart virtual remote internship
// implement power heap:

/***
 Your task is to implement a novel data structure -
 your project lead is calling it a power of two max heap.
 The heap must satisfy the heap property.
 Every parent node in the heap must have 2^x children.
 The value of x must be a parameter of the heap’s constructor.
 The heap must implement an insert method.
 The heap must implement a pop max method.
 The heap must be implemented in Java.
 The heap must be performant.
 You must use a more descriptive variable name than x in your implementation.
 */
public class PowerHeap <T extends Comparable <T>> {
    // return 2^(childPower)
    private final int childCount;
    private final ArrayList<T> data;

    public PowerHeap(int childPower){
        if (childPower <= 0){
            throw new IllegalArgumentException("childPower must be " +
                    "greater than zero");
        }
        childCount = (int) Math.pow(2, childPower);
        this.data = new ArrayList<T>();
    }

    public void insert(T item){
        data.add(item);
        int index = data.size() - 1;
        while (index > 0){
            index = this.swap(index);
        }
    }

    private int swap(int childIndex){
        T childValue = data.get(childIndex);
        int parentIndex = (int) Math.floor((float) (childIndex -1) / childCount);

        if (parentIndex >= 0){
            T parentValue = data.get(parentIndex);
            data.set(parentIndex, childValue);
            data.set(childIndex, parentValue);
            return parentIndex;
        }
        return -1;
    }

    public T popMax(){
        if (data.size() > 0){
            T maxItem = data.get(0);
            if (data.size() > 1){

                T lastItem = data.remove(data.size()-1);
                data.set(0,lastItem);
                int itemIndex = 0;
                while (itemIndex >=0){
                    itemIndex = this.swapDown(itemIndex);
                }
            }
            return maxItem;
        } else {
            return null;
        }
    }

    private int swapDown(int parentIndex){
        T parentValue = data.get(parentIndex);
        int largestChildIndex = 0;
        T largestChildValue = null;
        for (int i = 0; i < childCount; i++) {
            int childIndex = childCount * parentIndex +1;
            if (childIndex < data.size() - 1){
                T childValue = data.get(childIndex);
                if (largestChildValue == null || childValue.compareTo(largestChildValue)>0){
                    largestChildIndex = childIndex;
                    largestChildValue = childValue;
                }
            }
        }

        if (largestChildValue != null && parentValue.compareTo(largestChildValue)<0){
            data.set(parentIndex,largestChildValue);
            data.set(largestChildIndex, parentValue);
            return largestChildIndex;
        }
        return -1;
    }

}
