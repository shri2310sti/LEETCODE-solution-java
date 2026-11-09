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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        ListNode temp1 = list1, temp2 = list2;
        if(list1 == null && list2 == null) return null;

        while(temp1 != null && temp2 != null){
            
            if(temp1.val <= temp2.val){
                dummy.next = temp1;
                temp1 = temp1.next;
                dummy = dummy.next;
            } else{
                dummy.next = temp2;
                temp2 = temp2.next;
                dummy = dummy.next;
            }
        }
        while(temp1 != null){
            dummy.next = temp1;
            temp1 = temp1.next;
            dummy = dummy.next;
        }
        while(temp2 != null){
            dummy.next = temp2;
            temp2 = temp2.next;
            dummy = dummy.next;
        }
        return ans.next;
    }
}