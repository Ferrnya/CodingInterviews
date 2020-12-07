package chapter3;

import static java.lang.Math.*;


public class P114_printMaxDigits {
	//方法一：没有考虑大数问题，应该用字符串
	public static void printMaxDigits(int n) {
		if (n<=0) {
			System.out.println("Invalid Input.");
			//0 is invalid; 1 is valid
			return;
		}
		
		for (int i=1; i<Math.pow(10,n); i++) {
			System.out.println(i);
		}
	}
	
	//方法二：在字符串上模拟加法
	public static void printMaxDigits1(int n) {
		if(n<=0) {
			return;
		}
		char[] number = new char[n];
		for (int i=0; i<n;i++) {
			number[i] = '0';
		}
		while(Increment(number)) {
			printNumber(number);
		}
	}
	
	public static boolean Increment(char[] number) {
		for (int i=number.length-1; i>=0; i--) {
			if (number[i]<'9'&&number[i]>='0') {
				number[i]=(char)((int)number[i]+1);
				return true;
			} else if (number[i]=='9') {
				number[i]='0';
			} else {
				return false;
			}
		}
		return false;
		
	}
	
	public static void printNumber(char[] number) {
		boolean isBegining = true;
		
		for (int i=0; i<number.length; i++) {
			if (isBegining&&number[i]!='0') {
				isBegining=false;
			}
			if (!isBegining) {
				System.out.print(number[i]);
			}
		}
		
		System.out.print('\n');
	}
	
	//方法三：全排列打印
	public static void printMaxDigits2(int n) {
		if(n<=0) {
			return;
		}
		char[] number = new char[n];
		recursivePrint(number,0);
	}
	
	public static void recursivePrint(char[] number, int digit) {
		if (digit==number.length) {
			printNewNumber(number);
			return;
		}
		
		for (int i=0; i<10; i++) {
			number[digit] = (char)(i+'0');
			recursivePrint(number,digit+1);
		}
	}
	
	public static void printNewNumber(char[] number) {
		int index = 0;
	    while (index < number.length && number[index] == '0')
	        index++;
	    while (index < number.length)
	        System.out.print(number[index++]);
	    System.out.print('\n');	
	}
	
	
	
	
	
	public static void main(String[] args) {
		printMaxDigits(1);
		printMaxDigits1(1);
		printMaxDigits2(2);
	}

}
