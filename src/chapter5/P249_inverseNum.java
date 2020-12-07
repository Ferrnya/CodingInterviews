package chapter5;

public class P249_inverseNum {
	public static int inverse(int[] nums) {
		if(nums==null || nums.length<2)
			return 0;
		return coreInverse(nums,0,nums.length-1);
	}
	
	public static int coreInverse(int[] nums,int start,int end) {
		if(start>=end)
			return 0;
		int mid = start+(end-start)/2;
		int left = coreInverse(nums,start,mid);
		int right = coreInverse(nums,mid+1,end);
		int count = inverseMerge(nums,start,mid,end);
		return left+right+count;
	}
	
	public static int inverseMerge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end-start+1];
		for(int i=0;i<=end-start;i++)
            temp[i] = nums[i+start];
		int left = 0;
		int right = mid+1-start;
		int index = start;
		int count = 0;
		while(left<=mid-start && right<=end-start) {
			if(temp[left]<=temp[right]) {
				nums[index++]=temp[left++];
			}else {
				nums[index++]=temp[right++];
				count+=(mid-start)-left+1;
			}
		}
		while (left<=mid-start)
            nums[index++] = temp[left++];
        while (right<=end-start)
            nums[index++] = temp[right++];
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {7,5,6,4};
		System.out.println(inverse(nums));
	}

}
