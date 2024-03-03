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
class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        int c=0;
        while(c < n && fast!=null){
            fast=fast.next;
            c++;
        }

        //fast.next!=null
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        //remove
        slow.next=slow.next.next;
        
        return dummy.next;
    }
}
