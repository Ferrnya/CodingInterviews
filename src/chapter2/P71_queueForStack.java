package chapter2;

public class P71_queueForStack {
	public static void main(String[] args)  {
		QueueForStack QStack = new QueueForStack();
		//Queue: 1 2 3
		QStack.appendTail(1);
		QStack.appendTail(2);
		QStack.appendTail(3);
		//dequeue 3
		System.out.println(QStack.deleteTail());
		//dequeue 2
		System.out.println(QStack.deleteTail());
		//dequeue 1
		System.out.println(QStack.deleteTail());
		
	}
}
