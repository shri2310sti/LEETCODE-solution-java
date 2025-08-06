/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
    
        while(d1 != d2) {
            d1 = d1.next;
            d2 = d2.next;
            if(d1 == d2) return d1;
            if(d1 == null) d1 = headB;
            if(d2 == null) d2 = headA;
        }
        
        return d1;
    }
}