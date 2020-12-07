package chapter6;
import java.util.*;

public class P292_maxQueue {
	public static class maxQueue<T extends Comparable>{
		private Deque<InternalData<T>> maxDeque;
		private Deque<InternalData<T>> dataDeque;
		private int curIndex;
		
		public maxQueue() {
			this.maxDeque = new ArrayDeque<InternalData<T>>();
			this.dataDeque = new ArrayDeque<InternalData<T>>();
			this.curIndex = 0;
		}
		
		public T max() {
			if(maxDeque.isEmpty())
				return null;
			return maxDeque.getFirst().value;
		}
		
		public void pushBack(T value) {
			while(!maxDeque.isEmpty() && value.compareTo(maxDeque.getLast().value)>=0)
				maxDeque.removeLast();
			InternalData<T> addData = new InternalData(value,curIndex);
			maxDeque.addLast(addData);
			dataDeque.addLast(addData);
			curIndex++;
		}
		
		public T popFront() {
			if(dataDeque.isEmpty())
				return null;
			InternalData<T> delData = dataDeque.removeFirst();
			if(delData.index == maxDeque.getFirst().index)
				maxDeque.removeFirst();
			return delData.value;
		}
		
		
		
		
		public static class InternalData<M extends Comparable>{
			public M value;
			public int index;
			public InternalData(M value,int index) {
				this.value = value;
				this.index = index;
			}
		}
	}
	
	public static void main(String[] args) {
		maxQueue<Integer> queue = new maxQueue <>();
        queue.pushBack(3);
        System.out.println(queue.max());
        queue.pushBack(5);
        System.out.println(queue.max());
        queue.pushBack(1);
        System.out.println(queue.max());
        System.out.println("开始出队后，调用max");
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());

    }
	
	

}
