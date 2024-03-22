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
    public ListNode midNode(ListNode head){
        ListNode s = head;
        ListNode f = head;
        
        while(f.next!=null && f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        
        return s;
    }
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        
        while(curr!=null){
            ListNode save = curr.next;
            curr.next = prev;
            prev = curr;
            curr = save;
        }
        
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        boolean flag = true;
        ListNode ptr = head;
        
        ListNode mid = midNode(head);
        ListNode newhead = reverse(mid.next);
        
        ListNode ptr2 = newhead;
        
        while(ptr2!=null){
            if(ptr.val != ptr2.val) {
                flag = false;
                break; }
            
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        
        reverse(newhead);
        
        return flag;
    }
}
