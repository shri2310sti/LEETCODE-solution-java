import java.util.HashSet;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a set for fast lookups of nums values
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Dummy node to handle cases where we need to remove the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;

        // Traverse the linked list
        while (current.next != null) {
            // If the next node's value exists in the set, remove it
            if (set.contains(current.next.val)) {
                current.next = current.next.next; // Remove the node
            } else {
                current = current.next; // Move to the next node
            }
        }

        // Return the modified list starting from the next node of dummy
        return dummy.next;
    }
}
