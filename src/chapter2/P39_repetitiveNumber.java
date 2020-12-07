package chapter2;

public class P39_repetitiveNumber {
	public static int duplicate(int[] number, int length) {
		if (length<2) {
			return -1;
		}
		int temp;
		for (int i=0; i<length; i++) {
			while (number[i]!=i) {
				if (number[i] == number[number[i]]) {
					return number[i];
				} else {
					temp = number[number[i]];
					number[number[i]] = number[i];
					number[i] = temp;
				}
				
				
			}
		}
		return -1;
	}
	
	public static void main (String[] args) {
		int [] number1 = {1,2,1};
		int [] number2 = {1,2,0};
		System.out.println(duplicate(number1,3));
		System.out.println(duplicate(number2,3));
	}
}
