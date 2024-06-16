/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize pointers
        ListNode cur = dummy, nex = dummy, pre = dummy;
        int count = 0;
        
        // Count the number of nodes in the list
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        
        // Reverse every k nodes
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        
        return dummy.next;
    }
}
