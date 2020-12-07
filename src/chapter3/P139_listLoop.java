package chapter3;
import base.ListNode;

public class P139_listLoop {
	public static ListNode<Integer> loopStart(ListNode<Integer> head){
		if (head==null || head.next==null) {
			return null;
		}
		ListNode<Integer> first=head;
		ListNode<Integer> last=head;
		
		do {
			first = first.next.next;
			last = last.next;
		}while(last!=first);
		first = head;
		
		while (first!=last) {
			first = first.next;
			last = last.next;
		}
		return last;
		
	}
	
	public static void main(String args[]) {
		ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node7 = new ListNode<>(7);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;
        ListNode<Integer> start = loopStart(head);
        System.out.println(start.val);

	}
}
