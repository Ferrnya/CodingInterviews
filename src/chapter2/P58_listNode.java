package chapter2;
import base.ListNode;


/**
 * ��ͷ��β��ӡ����
 * @author Fern
 * ��Ŀ����������һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 */

// public class ListNode{
//     int val;
//     ListNode next = null;	
//     ListNode(int val) {
//         this.val = val;
//     }
// }

import java.util.ArrayList;
import java.util.*;
public class P58_listNode {
    public static ArrayList<Integer> printListFromTailToHead(ListNode<Integer> listNode) {
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (ListNode<Integer> x = listNode;x != null;x=x.next){
            s.push(x.val);
        }
        while (!s.isEmpty()){
            a.add(s.pop());
        }
        return a;
    }
    
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next=new ListNode<Integer>(2);
        head.next.next=new ListNode<Integer>(3);
        System.out.println(printListFromTailToHead(head));
    }
}

/**
  * ע�����
  * 1��stack��API�����У�push��pop��isEmpty��size
  * 2��java��û�ж���ListNode�࣬������д������֮ǰ��Ҫ����
  */
