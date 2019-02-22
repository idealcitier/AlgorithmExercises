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
//  利用龟兔赛跑的方法，设置一个快指针和一个慢指针。快指针每次走两个，慢指针每次走一个；若存在环，那么快慢指针必会相遇。
// 以此作为存在存在闭环的依据
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {return false;}
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;

    }
}