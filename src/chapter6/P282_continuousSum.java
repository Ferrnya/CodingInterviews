package chapter6;
import java.util.ArrayList;

public class P282_continuousSum {
	public static ArrayList<ArrayList<Integer>> find(int sum){
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		
		int small=1;
		int big=2;
		int curSum=3;
		
		while(big<sum) {
			if(curSum>sum) {
				curSum-=small;
				small++;
			}
			else if(curSum<sum) {
				big++;
				curSum+=big;	
			}
			else {
				ArrayList<Integer> result = new ArrayList<Integer>();
				for(int i=small;i<=big;i++) 
					result.add(i);
				output.add(result);
				curSum-=small;
				small++;
				big++;
				curSum+=big;
				
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> output = find(15);
		for (int i=0;i<output.size();i++) {
			ArrayList<Integer> result = output.get(i);
			for(int j=0;j<result.size();j++)
				System.out.print(result.get(j)+" ");
			System.out.println();
		}
			
	}

}
