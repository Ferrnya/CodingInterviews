package chapter6;

public class P266_differentNum {
	public static int find(int[] nums) {
		if(nums==null || nums.length==0 ) 
			return 0;
		int output = -1;
		int index = getNum(nums, 0,nums.length);
		if(index>-1) 
			output = nums[index];
		return output;
	}
	
	public static int getNum(int[] nums, int start, int end) {
		if(start>end)
			return -1;
		 int midIndex = (start+end)/2;
		 if(midIndex!=nums[midIndex]) {
			 if((midIndex>0 && nums[midIndex-1]==midIndex-1)||midIndex==0) 
				 return midIndex;
			 else
				 end = midIndex-1;
		 }else {
			 start = midIndex+1;
		 }
		 
		 return getNum(nums,start,end);
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,5,6,7,8};
		System.out.println(find(nums));
	}
}
