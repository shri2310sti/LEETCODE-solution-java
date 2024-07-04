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
    public ListNode mergeNodes(ListNode head) {
        // Dummy node to help with easy result list creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse the list starting from head.next since head is guaranteed to be zero
        ListNode iterator = head.next;
        int sum = 0;

        while (iterator != null) {
            if (iterator.val == 0) {
                // We encountered a zero, create a new node with the accumulated sum
                current.next = new ListNode(sum);
                current = current.next; // Move to the newly created node
                sum = 0; // Reset sum for the next group
            } else {
                // Accumulate the sum
                sum += iterator.val;
            }
            // Move to the next node
            iterator = iterator.next;
        }
        
        return dummy.next; // The head of the new list
    }
}
