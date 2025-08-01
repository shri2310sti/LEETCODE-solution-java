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
        ListNode t1 = headA;
        while(t1 != null){

            for(ListNode curr = headB; curr != null; curr = curr.next){
                
                if(t1 == curr) return t1;
                
            }
            t1 = t1.next;
        }
        return null;
    }
}