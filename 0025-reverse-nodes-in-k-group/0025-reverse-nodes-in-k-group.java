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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        //we need to count the number of nodes and then we find the number of groups it can be divided into
        int count = 0;
        for (ListNode temp = head; temp != null; temp = temp.next)
            count++;
        int groups = count / k; //number of groups is equal to total nodes / k
        ListNode dummy = new ListNode(-1, head); //for returning the value of modified list
        ListNode lastTail = dummy; //point towards the last tail of the previous group
        ListNode curr = head; //points to first value of fresh group
        for (int group = 0; group < groups; group++) {
            ListNode tail = curr; //since head of list becomes the tail after reversal, we point towards it
            ListNode rev = null;
            //reversing the k nodes
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = rev;
                rev = curr;
                curr = temp;
            }
            //rev will point towards the last node of the group being reversed (in original list)
            //curr will point towards the next value of that in the original list
            lastTail.next = rev;
            //anchoring the reversed list with the remaining list
            tail.next = curr;
            //updating the last tail of the list
            lastTail = tail; 
        }
        return dummy.next;
    }
}