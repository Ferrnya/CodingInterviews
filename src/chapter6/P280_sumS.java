package chapter6;
import java.util.ArrayList;

public class P280_sumS {
	public static ArrayList<Integer> find(int[] nums, int k){
		ArrayList<Integer> output = new ArrayList<Integer>();
		if(nums==null || nums.length<2)
			return output;
		int start = 0;
		int end = nums.length-1;
		while(start<end) {
			int cur = nums[start]+nums[end];
			if(cur==k) {
				output.add(nums[start]);
				output.add(nums[end]);
				return output;
			}
			else if(cur>k)
				end--;
			else
				start++;
		}
		return output;
	}
	
	public static void main(String[] args){
        int[] data = new int[]{1,2,4,7,11,15};
        ArrayList<Integer> result = find(data,15);
        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }
	

}
