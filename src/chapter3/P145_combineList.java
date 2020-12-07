package chapter3;
import base.ListNode;

public class P145_combineList {
	//µÝ¹é
	public static ListNode<Integer> combine(ListNode<Integer> head1, ListNode<Integer> head2){
		if (head1==null) {
			return head2;
		}
		if (head2==null) {
			return head1;
		}
		ListNode<Integer> head = null;
		
		if (head1.val<head2.val) {
			head = head1;
			head.next = combine(head1.next, head2);
		}else {
			head = head2;
			head.next = combine(head1, head2.next);
		}
		
		return head;
	}
	
	//µü´ú
	public static ListNode<Integer> combine1(ListNode<Integer> head1, ListNode<Integer> head2){
		ListNode<Integer> head = new ListNode<Integer>(-1);
	    ListNode<Integer> cur = head;
	    while (head1 != null && head2 != null) {
	        if (head1.val <= head2.val) {
	            cur.next = head1;
	            head1 = head1.next;
	        } else {
	            cur.next = head2;
	            head2 = head2.next;
	        }
	        cur = cur.next;
	    }
	    if (head1 != null)
	        cur.next = head1;
	    if (head2 != null)
	        cur.next = head2;
	    return head.next;
	}
	
	public static void main(String args[]) {
		ListNode<Integer> head1 = new ListNode<>(1);
        head1.next= new ListNode<>(3);
        head1.next.next = new ListNode<>(5);
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next= new ListNode<>(4);
        head2.next.next = new ListNode<>(6);
        System.out.println(head1);
        System.out.println(head2);
//        System.out.println(combine(head1,head2));
        System.out.println(combine1(head1,head2));

	}
	

}
