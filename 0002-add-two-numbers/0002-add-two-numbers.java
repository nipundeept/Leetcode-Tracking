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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode curr1 = l1, curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode ansp = dummy;
        //traversing both the list and there are chances that one of the list may point to null, so the loop terminates due to that list
        while (curr1 != null && curr2 != null) {
            sum = curr1.val + curr2.val + carry;
            ListNode node = new ListNode(sum % 10);
            ansp.next = node;
            ansp = ansp.next;
            carry = sum / 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        //if list2 is empty, we traverse the list1 and continue the addition until it points to null
        while (curr1 != null) {
            sum = curr1.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            ansp.next = node;
            ansp = ansp.next;
            curr1 = curr1.next;
        }
        //if list1 is empty, we traverse the list2 and continue the addition until it points to null
        while (curr2 != null) {
            sum = curr2.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            ansp.next = node; //appending the current node to the chain of result node
            ansp = ansp.next; //result node points to the latest added node
            curr2 = curr2.next;
        }
        //if carry is remaining, we need to append that carry at the end, and if it does not exist, the result is already computed
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            ansp.next = node;
        }
        //returning the next node of the dummy node (which contains the resulting list)
        return dummy.next;
    }
}