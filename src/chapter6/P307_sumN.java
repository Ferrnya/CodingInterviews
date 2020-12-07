package chapter6;

public class P307_sumN {
	public static int sumN(int n) {
		int sum = n;
		boolean b = (n>0) && ((sum += sumN(n-1))>0);
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sumN(4));
	}

}
