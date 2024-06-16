class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // Dummy node to start the merged list
        ListNode current = dummy; // Pointer to traverse the merged list
        
        // Traverse both lists and compare their values
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Connect current to list1
                list1 = list1.next; // Move list1 pointer forward
            } else {
                current.next = list2; // Connect current to list2
                list2 = list2.next; // Move list2 pointer forward
            }
            current = current.next; // Move current pointer forward
        }
        
        // Append remaining nodes from list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return dummy.next; // Return the head of the merged list (after the dummy node)
    }
}
