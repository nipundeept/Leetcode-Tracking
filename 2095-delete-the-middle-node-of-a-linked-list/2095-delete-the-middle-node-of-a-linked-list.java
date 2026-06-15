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
    public ListNode deleteMiddle(ListNode head) {
        //optimal O(n) approach using tortoise and hare algorithm in one pass.
        if (head == null || head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head; //a step ahead from the slow pointer. As fast reaches the end, slow will land on (mid - 1)th node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is now on (mid - 1)th node
        slow.next = slow.next.next; //changing the linking of the next node to the next next node (bypass maneuver)
        return dummy.next;
    }
}