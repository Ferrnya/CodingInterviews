package chapter2;
import base.ListNode;


/**
 * 从头到尾打印链表
 * @author Fern
 * 题目描述：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
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
  * 注意事项：
  * 1、stack的API方法有：push，pop，isEmpty，size
  * 2、java中没有定义ListNode类，所以在写主函数之前需要定义
  */
