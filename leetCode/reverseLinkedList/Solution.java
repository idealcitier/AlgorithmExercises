/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//  基本的思路就是把该节点的next指向它的前驱节点
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = dummy;
            dummy =  curr;
            curr = tmp;

        }
        return dummy;
    }
}