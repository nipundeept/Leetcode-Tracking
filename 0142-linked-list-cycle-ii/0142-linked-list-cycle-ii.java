/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //optimal approach using tortoise and hare algorithm and cycle detection
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //cycle is detected
                slow = head; //reset one of the pointers to the head of the linked list
                while (slow != fast) {
                slow = slow.next; //advance them both by one and at the end they will point to the Node where the cycle has started
                fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}