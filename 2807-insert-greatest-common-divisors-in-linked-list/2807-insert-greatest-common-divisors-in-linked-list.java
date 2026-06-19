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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            int a = curr.val, b = temp.val;
            ListNode newNode = new ListNode (hcf(a, b));
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }
        return head;
    }

    private int hcf(int a, int b) {
        //Euclidean Algorithm
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
        //gcd(a,b) = gcd(a−b,b) = gcd(a−2b,b) = ⋯ =gcd(a%b,b) = gcd(b,a % b)
    }
}