package chapter6;
import java.math.*;
import java.text.DecimalFormat;

public class P294_dicesProbability {
	final static int dicesMaxNum = 6;
	public static void printProbability(int n){
		if(n<1)
			return;
		int maxSum = dicesMaxNum*n;
		int[][] result = new int[2][maxSum+1];
		int flag = 0;
		for(int i=1;i<=dicesMaxNum;i++)
			result[flag][i]=1;
		
		for(int j=2;j<=n;j++) {
			flag = 1-flag;
			for(int k=1;k<j;k++) {
				result[flag][k]=0;
			}
			for(int i=j;i<=dicesMaxNum*j;i++) {
				int count=1;
				result[flag][i]=0;
				while(i-count>0 && count<=6) {
					result[flag][i]+=result[1-flag][i-count];
					count++;
				}
			}
		}
		System.out.println("骰子数为："+n);
		double total = Math.pow(dicesMaxNum, n);
		DecimalFormat df = new DecimalFormat("0.000");
		for (int i = n; i <= maxSum; i++) {
			System.out.print(df.format(result[flag][i] / total) + " ");
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		printProbability(3);
	}

}
