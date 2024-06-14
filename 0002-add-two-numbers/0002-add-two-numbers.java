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
        ListNode dummy = new ListNode(); // Dummy node to simplify the code
        ListNode curr = dummy;
        int carry = 0;

        // Iterate through both linked lists until both are empty
        while (l1 != null || l2 != null) {
            int sum = carry; // Initialize sum with carry from the previous addition

            // Add the current digits if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Update carry and create a new node with the sum
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        // If there's still a carry after the addition, create a new node for it
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next; // Return the next node of the dummy node, which is the head of the result
    }
}