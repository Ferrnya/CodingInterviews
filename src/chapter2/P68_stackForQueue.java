package chapter2;

public class P68_stackForQueue {
	
	public static void main(String[] args)  {
		StackForQueue SQueue = new StackForQueue();
		//Queue: 1 2 3
		SQueue.appendTail(1);
		SQueue.appendTail(2);
		SQueue.appendTail(3);
		//dequeue 1
		System.out.println(SQueue.deleteTail());
		//dequeue 2
		System.out.println(SQueue.deleteTail());
		//dequeue 3
		System.out.println(SQueue.deleteTail());
		
	}

}
