package chapter6;
import base.ListNode;

public class P300_lastNum {
	public static int lastNum1(int n,int m) {
		if(n<1 || m<1)
			return -1;
		ListNode<Integer> head = new ListNode<Integer>(0);
		ListNode<Integer> cur = head;
		for(int i=1;i<n;i++) {
			ListNode<Integer> node = new ListNode<Integer>(i);
			cur.next = node;
			cur = cur.next;
		}
		cur.next = head;
		cur = head;
		while(true) {
			if(cur.next==cur)
				return cur.val;
			for(int i=1;i<m;i++)
				cur=cur.next;
			cur.val = cur.next.val;
			cur.next = cur.next.next;
		}
	}
	
	public static int lastNum2(int n,int m) {
		if(n==0)
			return -1;
		if(n==1)
			return 0;
		return (lastNum2(n-1,m)+m)%n;
	}
	
	public static void main(String[] args) {
		System.out.println(lastNum1(5,3));
		System.out.println(lastNum2(5,3));
	}

}
