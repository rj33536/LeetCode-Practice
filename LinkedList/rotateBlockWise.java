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
    public ListNode reverse(ListNode head){
        ListNode prev = null, me = head, next;
        while(me!=null){
            next = me.next;
            me.next = prev;
            prev = me;
            me = next;
        }
        return prev;
    }
    public ListNode rotateBlockWise(ListNode head, int k) {
    
        ListNode temp = head,prev = null,myHead, dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        while(temp!=null){
            prev = temp;
            for(int i=1;i<k;i++){
                if(temp==null){
                    break;
                }
                temp = temp.next;
            }
            //temp==null
            if(temp==null){
                ListNode rv = reverse(prev);
                dummy.next = rv;
                break;
            }
            ListNode rm = temp.next;
            temp.next = null;
            ListNode rv = reverse(prev);
            dummy.next = rv;
            dummy = prev;
            temp = rm;
        }
        
       return dummyHead.next; 
        
    }
}
