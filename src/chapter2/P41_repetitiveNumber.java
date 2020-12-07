package chapter2;

public class P41_repetitiveNumber {
	public static int duplicate (int[] number, int length) {
		if (length<2) {
			return -1;
		}
		int start = 1;
		int end = length-1;
		
		while (end>=start) {
			int middle = (end-start)/2+start;
			int count = countNumber(number,length,start,middle);
			if (start==end) {
				if (count>1) {
					return start;
				}else {
					return -1;
				}
			}
			
			if (count>(middle-start)+1) {
				end = middle;
			}else {
				start = middle+1;
			}
		}
		
		return -1;
		                                                                                                                        
	}
	
	public static int countNumber(int[] number,int length, int start, int middle) {
		if (number == null) {
			return -1;
		}
		
		int count = 0;
		for (int i=0; i<length; i++) {
			if(number[i]>=start && number[i]<=middle) {
				count += 1;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int [] number1 = {1,2,1};
		int [] number2 = {1,2,2,3};
		int [] number3 = {2,3,5,4,3,2,6,7};
		System.out.println(duplicate(number1,3));
		System.out.println(duplicate(number2,4));
		System.out.println(duplicate(number3,8));
	}
	
	

}
