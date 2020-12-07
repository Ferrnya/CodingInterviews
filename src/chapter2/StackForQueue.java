package chapter2;

import java.util.Stack;

public class StackForQueue {
	private static Stack<Integer> stack1 = new Stack<Integer>();
	private static Stack<Integer> stack2 = new Stack<Integer>();
	
	public void appendTail(Integer a) {
		stack1.push(a);
	}
	
	public int deleteTail(){
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

}
