package chapter6;

public class P267_differentIndex {
	public static int find(int[] nums) {
		if(nums==null || nums.length==0)
			return -1;
		int index = coreFind(nums,0,nums.length-1);
		int output = -1;
		if(index>-1) 
			output = index;
		
		return output;
	}
	
	public static int coreFind(int[] nums,int start,int end) {
		 if(start>end)
			return -1;
		 int midIndex = (start+end)/2;
		 if(nums[midIndex]==midIndex) 
			 return midIndex;
		 else if(nums[midIndex]>midIndex)
			 end = midIndex-1;
		 else
			 start = midIndex+1;
		 
		 return coreFind(nums,start,end);
	}
	
	public static void main(String[] args) {
		int[] nums = {-3,-1,1,3,5};
		System.out.println(find(nums));
		
	}

}
