package chapter3;

public class P110_power {
	//ʱ�临�Ӷ�Ϊ O(N)
	public static double Power(double base,int exponent) {
		int new_exponent=exponent;
		if (exponent==0) {return 1;}
		if (Double.compare(base,0.0)==0 && exponent<0) {
			return 1;
		}
		if (exponent<0) {new_exponent=-exponent;}
		
		double count = 1;
		for(int i=1;i<=new_exponent;i++) {
			count *= base; 
		}
		
		if (exponent<0) {
			return 1/count;
		}
		
		return count;
		
	}
	
	//ʱ�临�Ӷ�Ϊ O(log(N))
	public static double myPow(double x, int n) {
		if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
	}
	
	public static void main (String[] args) {
		System.out.println("The power is "+Power(2,2));
		System.out.println("The power is "+Power(0.00,-2));
		System.out.println("The power is "+myPow(2,2));
		System.out.println("The power is "+myPow(0.00,-2));
	}

}
