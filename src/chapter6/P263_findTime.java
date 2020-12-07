package chapter6;

public class P263_findTime {
	public static int find(int[] nums, int number) {
		if(nums==null || nums.length==0 || nums[0]>number || nums[nums.length-1]<number) 
			return 0;
		
		
		int firstIndex = getFirst(nums, number,0,nums.length);
		int lastIndex = getLast(nums, number,0,nums.length);
		int output = 0;
		if (firstIndex>-1 && lastIndex>-1)
			output = lastIndex-firstIndex+1;
		return output;
	}
	
	public static int getFirst(int[] nums, int number,int start,int end) {
		 if(start>end)
			return -1;
		 int midIndex = (start+end)/2;
		 if(nums[midIndex]==number) {
			 if((midIndex>0 && nums[midIndex-1]!=number) || midIndex==0) 
				 return midIndex;
			 else 
				 end = midIndex-1;
		 }
		 else if(nums[midIndex] > number)
			 end = midIndex-1;
		 else
			 start = midIndex+1;
		 
		 return getFirst(nums,number,start,end);
	}
	
	public static int getLast(int[] nums, int number,int start,int end) {
		if(start>end)
			return -1;
		 int midIndex = (start+end)/2;
		 if(nums[midIndex]==number) {
			 if((midIndex<nums.length-1 && nums[midIndex+1]!=number) || midIndex==nums.length-1) 
				 return midIndex;
			 else 
				 start = midIndex+1;
		 }
		 else if(nums[midIndex] < number)
			 start = midIndex+1;
		 else
			 end = midIndex-1;
		 
		 return getLast(nums,number,start,end);
	}
	
	public static void main(String[] args) {
		System.out.println(find(new int[] {1,2,3,3,3,3},3));
	}
	

}
 