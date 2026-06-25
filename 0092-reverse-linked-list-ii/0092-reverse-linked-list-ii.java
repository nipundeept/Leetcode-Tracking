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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode anchor = dummy;
        for (int i = 0; i < left - 1; i++) {
            anchor = anchor.next;
        }
        //anchor now sits on one node before the reversal node
        ListNode curr = anchor.next; //accessing the node from where it is to be reversed
        ListNode rev = null;
        while (left <= right) {
            ListNode temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
            left++;
        }
        ListNode point = rev;
        while (point.next != null) {
            point = point.next;
        }
        point.next = curr;
        anchor.next = rev;
        return dummy.next;
    }
}