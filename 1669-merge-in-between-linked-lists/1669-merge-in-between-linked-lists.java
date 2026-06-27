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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode (0, list1);
        ListNode curr = dummy;
        for (int i = 0; i < a; i++) {
            curr = curr.next;
        }
        ListNode anchor = curr.next;
        for (int i = 0; i < b - a; i++) {
            anchor = anchor.next;
        }
        curr.next = list2;
        ListNode temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = anchor.next;
        return dummy.next;
    }
}