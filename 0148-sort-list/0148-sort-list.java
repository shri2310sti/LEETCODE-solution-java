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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode left = head, right = mid.next;
        mid.next = null;
        ListNode leftHead = sortList(left);
        ListNode rightHead = sortList(right);
        return mergeSortedList(leftHead, rightHead);
    }
    private static ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode mergeSortedList(ListNode t1, ListNode t2){
        
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val) {
                temp.next = t1;
                // temp = t1;
                t1 = t1.next;
            }else {
                temp.next = t2;
                // temp = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        // while(t1 != null){
        //     temp.next = t1;
        //     temp = t1;
        //     t1 = t1.next;
        // }
        // while(t2 != null){
        //     temp.next = t2;
        //     temp = t2;
        //     t2 = t2.next;
        // }

        if(t1 != null){
            temp.next = t1;
        } else{
            temp.next=t2;
        }
        return dummyNode.next;
    }
}