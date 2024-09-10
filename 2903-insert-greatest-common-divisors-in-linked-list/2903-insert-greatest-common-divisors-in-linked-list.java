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
        if (head == null || head.next == null) {
            return head;  // If there's only one node or the list is empty, return the head.
        }
        
        ListNode current = head;
        
        // Traverse through the linked list
        while (current != null && current.next != null) {
            // Get the value of the current node and the next node
            int gcdValue = gcd(current.val, current.next.val);
            
            // Create a new node with the GCD value
            ListNode gcdNode = new ListNode(gcdValue);
            
            // Insert this new node between current and current.next
            gcdNode.next = current.next;
            current.next = gcdNode;
            
            // Move to the next pair (skip over the newly inserted GCD node)
            current = gcdNode.next;
        }
        
        return head;
    }
    
    // Helper function to calculate the GCD of two integers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
