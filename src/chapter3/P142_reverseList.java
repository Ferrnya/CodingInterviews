package chapter3;
import base.ListNode;

public class P142_reverseList {
	public static ListNode<Integer> reverse(ListNode<Integer> head){
		if (head==null || head.next==null) {
			return head;
		}

		ListNode<Integer> reverseHead = null;
		ListNode<Integer> cur = head;
		ListNode<Integer> pre = null;
		while (cur!=null) {
			ListNode<Integer> last = cur.next;
			if (last==null) {
				reverseHead = cur;
			}
			cur.next = pre;
			pre = cur;
			cur=last;
		}
		return reverseHead;
	}
	
	public static void main(String args[]) {
		ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(head);
        System.out.println(reverse(head));

	}

}
