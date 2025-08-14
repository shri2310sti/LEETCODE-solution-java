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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevNode = null;
        while(temp != null){
            ListNode kTHNode = getKthNode(temp, k);
            
            if(kTHNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = kTHNode.next;
            kTHNode.next = null;
            reverse(temp);

            if(temp == head) head = kTHNode;
            else prevNode.next = kTHNode;

            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
    private ListNode getKthNode(ListNode temp, int k){
        k = k-1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    private void reverse(ListNode node){
        ListNode prev = null, temp = node;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return ;
    }
}