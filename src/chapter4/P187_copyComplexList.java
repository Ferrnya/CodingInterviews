package chapter4;
import chapter4.ComplexListNode;
import java.util.HashMap;

public class P187_copyComplexList {
	//解法一
	public static ComplexListNode<Integer> copy1(ComplexListNode<Integer> head){
		ComplexListNode<Integer> newHead = new ComplexListNode<Integer>(head.val);
		ComplexListNode<Integer> cur = head.next;
		ComplexListNode<Integer> newCur;
		ComplexListNode<Integer> newCurPrev = newHead;
		while (cur!=null) {
			newCur = new ComplexListNode<Integer>(cur.val);
			newCurPrev.next = newCur;
			newCurPrev = newCurPrev.next;
			cur = cur.next;			
		}
		
		cur = head;
		newCur = newHead;
		ComplexListNode<Integer> temp = head;
		ComplexListNode<Integer> newTemp = newHead;
		while(cur!=null) {
			if (cur.sibling!=null) {
				temp = head;
				newTemp = newHead;
				while (temp!=cur.sibling) {
					temp = temp.next;
					newTemp = newTemp.next;
				}
				newCur.sibling = newTemp;
			}
			cur = cur.next;
			newCur = newCur.next;
		}
		return newHead;
	}
	
	//解法二
	public static ComplexListNode<Integer> copy2(ComplexListNode<Integer> head){
		HashMap<ComplexListNode<Integer>,ComplexListNode<Integer>> hmap = new HashMap<ComplexListNode<Integer>,ComplexListNode<Integer>>();
		ComplexListNode<Integer> newHead = new ComplexListNode<Integer>(head.val);
		hmap.put(head,newHead);
		ComplexListNode<Integer> cur = head.next;
		ComplexListNode<Integer> newCur;
		ComplexListNode<Integer> newCurPrev = newHead;
		while (cur!=null) {
			newCur = new ComplexListNode<Integer>(cur.val);
			hmap.put(cur,newCur);
			newCurPrev.next = newCur;
			newCurPrev = newCurPrev.next;
			cur = cur.next;			
		}
		cur = head;
		newCur = newHead;
		while (cur!=null) {
			if(cur.sibling!=null) {
				newCur.sibling = hmap.get(cur.sibling);
			}
			cur = cur.next;
			newCur = newCur.next;
		}
		return newHead;
	}
	
	//解法三
	public static ComplexListNode<Integer> copy3(ComplexListNode<Integer> head){
		cloneNode(head);
		connectSibling(head);
		return reconnectNode(head);
	}
	

	public static void cloneNode(ComplexListNode<Integer> head) {
		ComplexListNode<Integer> node = head;
		while (node!=null) {
			ComplexListNode<Integer> clonenode = new ComplexListNode<Integer>(node.val);
			clonenode.next = node.next;
			clonenode.sibling = null;
			node.next = clonenode;
			node = clonenode.next;
		}
	}
	
	public static void connectSibling(ComplexListNode<Integer> head) {
		ComplexListNode<Integer> node = head;
		while(node!=null) {
			ComplexListNode<Integer> clonenode = node.next;
			if(node.sibling!=null) {
				clonenode.sibling = node.sibling.next;
			}
			node = clonenode.next;
		}
	}
	
	public static ComplexListNode<Integer> reconnectNode(ComplexListNode<Integer> head){
		ComplexListNode<Integer> node = head;
		ComplexListNode<Integer> newHead = null;
		ComplexListNode<Integer> clonenode = null;
		
		if (node!=null) {
			newHead = clonenode = node.next;
			node.next = clonenode.next;
			node = node.next;
		}
		
		while (node!=null) {
			clonenode.next = node.next;
			clonenode = clonenode.next;
			node.next = clonenode.next;
			node = node.next;
		}
		return newHead;
	}
	
	
	public static void main(String[] args) {
		ComplexListNode<Integer> head = new ComplexListNode<Integer>(1);
        ComplexListNode<Integer> c2 = new ComplexListNode<Integer>(2);
        ComplexListNode<Integer> c3 = new ComplexListNode<Integer>(3);
        ComplexListNode<Integer> c4 = new ComplexListNode<Integer>(4);
        ComplexListNode<Integer> c5 = new ComplexListNode<Integer>(5);
        head.next = c2;
        head.sibling = c3;
        head.next.next = c3;
        head.next.sibling = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.sibling = c2;
        System.out.println("original:"+'\t'+head);
        System.out.println("copy1:  "+'\t'+copy1(head));
        System.out.println("copy2:  "+'\t'+copy2(head));
        System.out.println("copy3:  "+'\t'+copy3(head));
	}

}
