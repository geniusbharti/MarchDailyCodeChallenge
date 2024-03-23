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
    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Step 1: Find the middle node
        ListNode mid = getMidNode(head);

        // Step 2: Reverse the second half of the list
        ListNode reversedHalf = reverseLinkedList(mid.next);
        mid.next = null;

        // Step 3: Merge the two halves alternately
        ListNode current = head;
        while (reversedHalf != null) {
            //saving nexts link
            ListNode temp1 = current.next;
            ListNode temp2 = reversedHalf.next;

            //changing links
            current.next = reversedHalf;
            reversedHalf.next = temp1;

            //updating ptrs curr and revhf
            current = temp1;
            reversedHalf = temp2;
        }
    }
}
