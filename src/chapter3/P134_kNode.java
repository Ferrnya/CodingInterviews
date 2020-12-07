package chapter3;
import base.ListNode;

public class P134_kNode {
	public static ListNode<Integer> kNode(ListNode<Integer> head,int k){
		if (head==null || k==0) {
			return head;
		}
		
		ListNode<Integer> first = head;
		ListNode<Integer> last = head;
		for (int i=0;i<k-1;i++) {
			if (first.next!=null) {
				first=first.next;
			}else {return null;}
		}
		while (first.next!=null) {
			first = first.next;
			last=last.next;
		}
		return last;
	}
	
	public static void main(String args[]) {
		ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
        System.out.println(kNode(head,3).val);
	}

}
