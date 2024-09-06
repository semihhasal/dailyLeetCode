import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class DeleteNodesFromLinkedList {

    public ListNode modifiedList(int[] numsArray, ListNode head) {
        List<Integer> nums = new ArrayList<>();
        for (int v : numsArray) {
            nums.add(v);
        }

        ListNode dummy =new ListNode(-1);
        ListNode temp = dummy;
        Set<Integer> s=new HashSet<>(nums);

        while (head != null) {
            if (!s.contains(head.val)) {
                temp.next = head;
                temp=temp.next;
            }
            head=head.next;
        }
        temp.next = null;
        return dummy.next;
    }



    public class ListNode {
     int val;
     ListNode next;
     ListNode() {

     }
        ListNode(int val) {
         this.val = val;
     }
        ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
  }
}
