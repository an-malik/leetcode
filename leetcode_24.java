// Leetcode_24
// Swap Nodes in Pairs

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode prev = head;
        ListNode curr = null, next = null;
        
        while(prev != null && prev.next != null) {
            curr = prev.next;
            next = curr.next;
            
            prev.next = next == null ? null : next.next == null ? next : next.next;;
            curr.next = prev;
            if(prev == head) head = curr;
            
            prev = next;
        }
        
        return head;
    }
}