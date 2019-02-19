/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // link--> https://leetcode.com/problems/add-two-numbers/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode curr = head;
        int carry = 0;
        while(n1 != null || n2 != null){
            int x = (n1 != null) ? n1.val : 0;
            int y = (n2 != null) ? n2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(n1 != null) n1 = n1.next;
            if(n2 != null) n2 = n2.next;
        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}