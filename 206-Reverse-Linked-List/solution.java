/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null)
			return head;
		
		ListNode cur = head;
		ListNode next = cur.next;
		cur.next = null;
		/*
		 null<-o  o->o->o->null
		 */
		while(next!=null){
			ListNode tmp = next;
			next = next.next;
			tmp.next = cur;
			cur = tmp;
		}
		
		return cur;
    }
}