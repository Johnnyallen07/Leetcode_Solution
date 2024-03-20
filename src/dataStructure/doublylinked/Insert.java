package dataStructure.doublylinked;

import dataStructure.DListNode;


public class Insert {

    // insert element to '|'
    public void insertAfter(DListNode list, char elem){
        DListNode copy = new DListNode(-1);
        copy.next = list;
        while(list!=null){
            if (list.val == '|'){
                DListNode next = list.next;
                list.next = new DListNode(elem);
                list.next.next = next;
            }
            list = list.next;
        }
        list = copy.next;
    }
}
