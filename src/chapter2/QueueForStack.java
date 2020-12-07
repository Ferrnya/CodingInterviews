package chapter2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueForStack {
	private static Queue<Integer> queue1 = new LinkedList<Integer>();
	private static Queue<Integer> queue2 = new LinkedList<Integer>();
	
	public void appendTail(Integer a) {
		queue1.offer(a);
	}
	
	public int deleteTail(){
		if (size()!=0) {
			if (!queue1.isEmpty()) {
				putToAnother();
				return queue1.poll();
				
			}else {
				putToAnother();
				return queue2.poll();
			}
		}else {
			System.out.println("The stack is empty!");
			return -1;
		}
	}
	
	public int size() {
		return queue1.size()+queue2.size();
	}
	
	public void putToAnother() {
		if (!queue1.isEmpty()) {
			while (queue1.size()>1) {
				queue2.offer(queue1.poll());
			}
		}else if (!queue2.isEmpty()) {
			while (queue2.size()>1) {
				queue1.offer(queue2.poll());
			}
		}
	}
	

}
