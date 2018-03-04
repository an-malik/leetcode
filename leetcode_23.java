# Leetcode_23
# Merge K sorted linked lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        int k = lists.length;
        if(k == 0) return null;
        if(k == 1) return lists[0];
        
        Queue<ListNode> lstQueue = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        ListNode result = new ListNode(0);
        ListNode head = result;
        
        for(ListNode temp : lists) {
            if(temp != null)
                lstQueue.add(temp);
        }
            
        while(!lstQueue.isEmpty()) {
            result.next = lstQueue.poll();
            result = result.next;
            
            if(result.next != null)
                lstQueue.add(result.next);
        }
        
        return head.next;
    }
}