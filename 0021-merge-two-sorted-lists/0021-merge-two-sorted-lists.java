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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1, curr2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode merge = dummy;
        while (curr1 != null && curr2 != null) {
            int data1 = curr1.val, data2 = curr2.val;
            if (data1 <= data2) {
                merge.next = curr1;
                curr1 = curr1.next;
            }
            else {
                merge.next = curr2;
                curr2 = curr2.next;
            }
            merge = merge.next;
        }
        while (curr1 != null) {
            merge.next = curr1;
            merge = merge.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            merge.next = curr2;
            merge = merge.next;
            curr2 = curr2.next;
        }
        return dummy.next;
    }
}