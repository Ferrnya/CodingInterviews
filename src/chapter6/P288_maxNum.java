package chapter6;
import java.util.*;

public class P288_maxNum {
	public static ArrayList<Integer> maxNum(int[] nums,int size){
		ArrayList<Integer> output = new ArrayList<Integer>();
		if(nums==null||nums.length==0||nums.length<size || size==0)
			return output;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i=0;i<size-1;i++) {
			while(!deque.isEmpty() && nums[i]>=nums[deque.getLast()]) 
				deque.removeLast();
			deque.addLast(i);			
		}
		
		for(int i=size-1;i<nums.length;i++) {
			while(!deque.isEmpty() && i-deque.getFirst()+1>size)
				deque.removeFirst();
			while(!deque.isEmpty() && nums[i]>=nums[deque.getLast()])
				deque.removeLast();
			deque.addLast(i);
			output.add(nums[deque.getFirst()]);
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> output = maxNum(nums,3);
		for(int i=0;i<output.size();i++)
			System.out.print(output.get(i)+" ");
	}
}
