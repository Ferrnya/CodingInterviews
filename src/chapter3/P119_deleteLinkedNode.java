package chapter3;
//
//import java.util.LinkedList;

//
//public class P119_deleteLinkedNode {
//	public static void delete(Node )
//
//}

/**
 * 得到要删除的节点，将后一个节点的内容复制过来，然后删除后一个节点的内容。就可以在O(1)复杂度下删除节点
 */
import base.ListNode;  
public class P119_deleteLinkedNode {  
	public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node) {
		if (head==node){
			if (head.next==null) {
				return null;
			}
			return head.next;
		} else if (node.next!=null) {
			node.val = node.next.val;
			node.next = node.next.next;
			return head;
			
		} else {
			ListNode<Integer> temp = head;
			while(temp.next!=node) {
				temp=temp.next;
			}
			temp.next=null;
			return head;
		}
		
		
		
	}
	
	
	public static void main(String[] args) {  
		ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        head.next = node2;
        node2.next = node3;
        System.out.println (head);
        head = deleteNode(head,node3);
        System.out.println (head);
        head = deleteNode(head,head);
        System.out.println (head);

    }  
}  
