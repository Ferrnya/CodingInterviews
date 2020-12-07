package chapter6;

public class P310_add {
	public static int add(int a,int b) {
		int sum;
		int carry;
		do {
			sum = a^b;
			carry = (a&b)<<1;
			a=sum;
			b=carry;
		}while(b!=0);
		
		return a;
			
	}
	
	public static void main(String[] args) {
		System.out.println(add(3,4));
	}
}
