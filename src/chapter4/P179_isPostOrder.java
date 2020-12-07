package chapter4;

public class P179_isPostOrder {
	public static boolean isPostOrder(int[] numbers) {
		if (numbers==null) {
			return false;
		}
		int length = numbers.length;
		
		return verifyPost(numbers,0,length-1);
	}
	
	public static boolean verifyPost(int[] numbers, int start, int end) {
		if(end-start<=1) {
			return true;
		}
		int root = numbers[end];
		
		int i = start;
		for (;i<end;i++) {
			if(numbers[i]>root) {
				break;
			}
		}
		
		int j = i;
		for (;j<end;j++) {
			if(numbers[j]<root) {
				return false;
			}
		}
		
		boolean left = true;
		if(i>0) {
			left = verifyPost(numbers,start,i-1);
		}
		
		boolean right = true;
		if(i<end) {
			right = verifyPost(numbers,i,end-1);
		}
		
		return right&&left;
	}
	
	public static boolean isPreOrder(int[] numbers) {
		if (numbers==null) {
			return false;
		}
		int length = numbers.length;
		
		return verifyPre(numbers,0,length-1);
	}
	
	public static boolean verifyPre(int[] numbers, int start, int end) {
		if(end-start<=1) {
			return true;
		}
		int root = numbers[start];
		
		int i = start+1;
		for (;i<end;i++) {
			if(numbers[i]>root) {
				break;
			}
		}
		
		int j = i;
		for (;j<=end;j++) {
			if(numbers[i]<root) {
				return false;
			}
		}
		
		
		boolean left = true;
		if(i>0) {
			left = verifyPre(numbers,start+1,i-1);
		}
		
		boolean right = true;
		if(i<end) {
			right = verifyPre(numbers,i,end);
		}
		
		return right&&left;
	}
	
	public static void main(String[] args) {
		int[] numbers1 = {5,7,6,9,11,10,8};
		int[] numbers2 = {7,4,6,5};
		System.out.println(isPostOrder(numbers1)); //true
		System.out.println(isPostOrder(numbers2)); //false
		int[] numbers3 = {8,6,5,7,10,9,11};
		int[] numbers4 = {5,7,4,6};
		System.out.println(isPreOrder(numbers3)); //true
		System.out.println(isPreOrder(numbers4)); //false
	}

}
