package chapter4;
import java.util.Stack;

public class P168_pushAndPop {
	public static boolean isPop(int[] pushList,int[] popList) {
		if (pushList==null || popList==null || popList.length!=pushList.length) {return false;}
		Stack<Integer> stack = new Stack<>();
		
		int pushIndex = 0;
		int popIndex=0;
		while(popIndex<popList.length) {
			if (stack.isEmpty() || stack.peek()!=popList[popIndex])	{
				if (pushIndex<pushList.length) {
					stack.push(pushList[pushIndex++]);
				}else {
					return false;
				}
			} else {
				stack.pop();
				popIndex++;
			}
		}
		
		return true;
		
	}
	
	public static void main(String args[]) {
		int[] pushList = {1,2,3,4,5};
		int[] popList = {4,5,3,2,1};
		int[] popList1 = {4,3,5,1,2};
		System.out.println(isPop(pushList,popList)); //true
		System.out.println(isPop(pushList,popList1)); //false
	}

}
