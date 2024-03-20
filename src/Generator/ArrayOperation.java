package Generator;

public class ArrayOperation {

    public double findMedianSortedArray(int[] nums){
        return (nums[-1+nums.length / 2] + nums[nums.length - nums.length / 2]) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int total_length = length1 + length2;


        // exchange the arr when the length is larger
        if (length1 > length2) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
            int tmp = length1;
            length1 = length2;
            length2 = tmp;
        }

        int min = 0, max = length1, mid = (total_length + 1) / 2;
        while (min <= max){
            int i = (min + max) / 2;
            int j = mid - i;
            if (i < max && nums2[j - 1] > nums1[i]){
                min = i + 1;
            } //  right move
            else if (i > min && nums1[i - 1] > nums2[j]){
                max = i - 1;
            } // left move
            else{
                int maxLeft = 0;
                if (i == 0){
                    maxLeft = nums2[j-1];
                }
                else if (j == 0){
                    maxLeft = nums1[i-1];
                } // nums1 is larger than nums 2
                else{
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((total_length) % 2 == 1){
                    return maxLeft;
                }

                int minRight = 0;
                if (i == length1){
                    minRight = nums2[j];
                }
                else if (j == length2){
                    minRight = nums1[i];
                }
                else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }


    // 2 array lists satisfy the ascending order
    public int[] merge2Lists(int[] list1, int[] list2) {
        int[] storage = new int[list1.length + list2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < list1.length + list2.length; k++) {
            if(i== list1.length && j != list2.length){
                storage[k] = list2[j++];
            }
            if (j==list2.length && i != list1.length){
                storage[k] = list1[i++];
            }
            if (i< list1.length && j < list2.length){
                if (list1[i] < list2[j]){
                    storage[k] = list1[i++];
                }
                else {
                    storage[k] = list2[j++];
                }
            }
        }
        return storage;
    }

    // 2 List notes satisfy ascending order
    public ListNode merge2Lists(ListNode list1, ListNode list2){
        if (list1 == null && list2 == null){
            return null;
        }
        ListNode storage = new ListNode();

        ListNode pre = storage;

        while (list1 != null || list2 != null){
            ListNode next = new ListNode(); // next storage
            if (list1 == null){
                pre.val = list2.val;
                list2 = list2.next;
            }
            else if (list2 == null){
                pre.val = list1.val;
                list1 = list1.next;
            }
            else{

                if (list1.val < list2.val){

                    pre.val = list1.val; // storage
                    list1 = list1.next; // increment
                }else{
                    pre.val = list2.val;
                    list2 = list2.next;
                }

            }

            pre.next = next;
            pre = next;

        }

        ListNode deleteFinalNode = new ListNode();
        ListNode test = storage;
        while (test.next != null){
            deleteFinalNode = test;
            test = test.next;

        }
        deleteFinalNode.next = null;
        return storage;


    }

    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;
        while (length > 1){
            int index = 0;
            for (int i = 0; i < length - 1; i++) {
                lists[index] = merge2Lists(lists[i], lists[++i]);
                index++;
            }
            if (length % 2 == 1){
                lists[index] = lists[index*2]; // odd situation. [0,1] [2,3] [4,5] 6: index: 3 node 6
                length = length / 2 + 1;
            }
            else {
                length = length / 2;
            }

        }
        if (length == 0){
            return null;
        }
        return lists[0];
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        list1.next = node1;
        node1.next = node2;

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);

        ListNode list3 = new ListNode(5);
        list3.next = new ListNode(6);


        ListNode list4 = null;
        ListNode list5 = null;
        ListNode[] list = {list4, list5};

        ArrayOperation test = new ArrayOperation();
        ListNode listNode = test.mergeKLists(list);
        System.out.println(listNode);




    }
}
