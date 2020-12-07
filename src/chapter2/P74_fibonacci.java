package chapter2;

public class P74_fibonacci {
	public static int fibonacci(int n) {
		if (n<0) {
			System.out.println("Invalid input!");
			return -1;
		}
		
		int[] results = {0,1};
		if (n<2) {
			return results[n];
		}
		
		int fibNum1 = 1;
		int fibNum2 = 0;
		int fibNum = 0;
		for (int i=2; i<=n;i++) {
			fibNum = fibNum1 + fibNum2;
			fibNum2 = fibNum1;
			fibNum1 = fibNum;
		}
		return fibNum;
	}
	
	public static void main(String[] args) {
		System.out.print(fibonacci(6));
	}

}
