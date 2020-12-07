package chapter4;
import java.util.Stack;

public class P165_minStack<T> {
	public static void main(String args[]) {
		minStack<Integer> min = new minStack<Integer>();
		min.push(4);
		min.push(3);
		min.push(2);
		min.push(1);
		System.out.println(min.min());
		min.pop();
		System.out.println(min.min());
		min.pop();
		System.out.println(min.min());
		min.pop();
		System.out.println(min.min());
		min.pop();
		System.out.println(min.min());
	}
	
	

}
