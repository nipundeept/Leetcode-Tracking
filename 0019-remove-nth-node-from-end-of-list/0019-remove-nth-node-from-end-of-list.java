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
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy; //initialising both slow and fast pointers
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next; // we move fast pointer in such as way that there is a n gap between slow and fast pointers
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //when fast is pointing to null, slow is pointing to 1 node behind the removal node
        slow.next = slow.next.next;
        return dummy.next;
    }
}