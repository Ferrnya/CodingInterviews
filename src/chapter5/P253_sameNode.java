package chapter5;
import base.ListNode;
import java.util.Stack;

public class P253_sameNode {
	public static ListNode<Integer> same(ListNode<Integer> head1, ListNode<Integer> head2) {
		if(head1.val==null || head2.val==null)
			return null;
		Stack<ListNode<Integer>> stack1 = new Stack<>();
		Stack<ListNode<Integer>> stack2 = new Stack<>();
		
		
		for(ListNode<Integer> node1=head1; node1!=null;node1=node1.next)
			stack1.push(node1);
		for(ListNode<Integer> node2=head2; node2!=null;node2=node2.next)
			stack2.push(node2);
		ListNode<Integer> commonNode = null;
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			if(stack1.peek()==stack2.peek()) {
				commonNode = stack1.pop();
				stack2.pop();
			}else {
				break;
			}
		}
		return commonNode;
	}
	
	public static void main(String[] args) {
		// 1->2->3->6->7
        //    4->5↗
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node7 = new ListNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;	
        ListNode<Integer> commonNode = same(node1,node4);
        System.out.println(commonNode.val);
	}

}
