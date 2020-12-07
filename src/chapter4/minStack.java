package chapter4;
import java.util.Stack;

public class minStack<T extends Comparable> {
	private Stack<T> mainStack = new Stack<>();
	private Stack<T> assitStack = new Stack<>();
	
	public void push(T val) {
		mainStack.push(val);
		if (assitStack.isEmpty()) {
			assitStack.push(val);
		}else {
			T temp = assitStack.peek();
			if ( temp.compareTo(val)<0) {
				assitStack.push(temp);
			}else {
				assitStack.push(val);
			}
		}
	}
	
	public T pop() {
		if(mainStack.isEmpty()) {return null;}
		assitStack.pop();
		return mainStack.pop();
	}
	
	public T min() {
		if(assitStack.isEmpty()) {return null;}
		return assitStack.peek();
	}

}
