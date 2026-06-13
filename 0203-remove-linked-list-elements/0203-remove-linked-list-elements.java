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
    public ListNode removeElements(ListNode head, int val) {
        //Creating a dummy node
        ListNode dummy = new ListNode(0);
        //attaching dummy to the first node of real list
        dummy.next = head;
        //Creating our own pointer to walk down the entire list
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; //bypass maneuver
            }
            else {
                curr = curr.next; //simply iterating towards next node
            }
        }
        return dummy.next;
    }
}