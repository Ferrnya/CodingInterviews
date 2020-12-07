package chapter3;
import base.ListNode;

public class P122_deleteDuplicatedNode {
	public static ListNode<Integer> deleteDuplicate(ListNode<Integer> head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode<Integer> pre = null;
		ListNode<Integer> cur = head;
		ListNode<Integer> post = head.next;
		boolean needDelete = false;
		while(post!=null) {
			if(cur.val==post.val) {
				needDelete = true;
				post = post.next;
			}
			else if(needDelete && cur.val!=post.val) {
				if(pre==null) {
					head = post;
				}else {
					pre.next = post;
				}
				cur = post;
				post = post.next;
				needDelete = false;
			}else {
				pre = cur;
				cur = post;
				post = post.next;
			}
		}
		if(needDelete && pre!=null) {
			pre.next=null;
		}
		else if (needDelete && pre==null) {
			head=null;
		}
		return head;
	}
	
	
	public static void main(String[] args) {  
		ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(2);
        head.next.next.next.next.next = new ListNode<>(3);
        System.out.println(head);
        head = deleteDuplicate(head);
        System.out.println(head);

    }  

}
