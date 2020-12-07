package chapter5;

public class P218_maxSum {
	public static int sum(int[] nums) {
		if(nums==null) {
			return 0;
		}
		int cumulativeSumNum = nums[0];
	    int maxSumNum = cumulativeSumNum;
	    
	    
	    for(int i=1;i<nums.length;i++) {
	    	if(cumulativeSumNum<0) {
	    		cumulativeSumNum = nums[i];
	    	}
	    	else {
	    		cumulativeSumNum += nums[i];	    		
	    	}
	    	if(cumulativeSumNum>maxSumNum) {
	    		maxSumNum = cumulativeSumNum;
	    	}
	    }
	    return maxSumNum;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,-2,3,10,-4,7,2,-5};
		System.out.println(sum(nums));
	}
	

}
