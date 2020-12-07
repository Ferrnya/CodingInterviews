package chapter6;

public class P312_multiply {
	public static int[] multiply(int[] A) {
		if(A==null || A.length==0)
			return null;
		int n = A.length;
		int[] B = new int[n];
			
		for(int i=0,product=1;i<n;product*=A[i],i++) 
			B[i] = product;
		for(int i=n-1,product=1;i>=0;product*=A[i],i--)
			B[i] *= product;
			
		return B;
	    
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = multiply(A);
		for (int i=0;i<B.length;i++)
			System.out.print(B[i]+" ");
	}

}
