package chapter5;

import java.util.Arrays;

public class P209_kNums {
	//使用快排的方法
	public static int[] kNums1(int[] nums, int k) {
		if(nums.length==0 || k>nums.length) {
			return null;
		}
			
		int left = 0;
		int right = nums.length-1;
		int mid = nums.length/2;
		int index = partition(nums,left,right);
		while (index!=mid) {
			if(index>mid) {
				index = partition(nums,left,index-1);
			}else {
				index = partition(nums,index+1,right);
			}
		}
		int[] output=Arrays.copyOf(nums, k);
		return output;
	}

	public static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		while(left<right) {
			while (left<right && nums[right]>=pivot) {
				right--;
			}
			if(left<right) {
				nums[left] = nums[right];
			}
			while (left<right && nums[left]<pivot) {
				left++;
			}
			if (left<right) {
				nums[right] = nums[left];
			}
		}
		nums[left] = pivot;
		return left;
	}
	
	//使用最大堆
	public static int[] kNums2(int[] nums, int k) {
		if(nums.length==0 || k>nums.length) {
			return null;
		}
		//建立最大堆
		int[] heap = new int[k+1];
		int i = 0;
		while(i<k) {
			heap[i+1]=nums[i];
			i++;
		}

		buildMaxHeap(heap);
		while(i<nums.length) {
			if(nums[i]<heap[1]) {
				heap[1]=nums[i];
				adjustMaxHeap(heap,1);
			}
			i++;
		}
		return heap;
	}
	
	public static void buildMaxHeap(int[] heap) {
		for (int i=heap.length/2;i>0;i--) {
			adjustMaxHeap(heap,i);
		}
	}
	
	public static void adjustMaxHeap(int[] heap, int i) {
		int left = i*2;
		int right = left+1;
		int max = i;
		if (left<heap.length && heap[left]>heap[max]) {
			max = left;
		}
		if (right<heap.length && heap[right]>heap[max]) {
			max = right;
		}
		if(max!=i) {
			int temp = heap[i];
			heap[i] = heap[max];
			heap[max] = temp;
			adjustMaxHeap(heap,max);
		}

	}
	
	public static void main(String[] args) {
		int[] nums = {4,5,1,6,2,7,3,8};
		int[] output = kNums1(nums,4);
		for (int i=0;i<output.length;i++) {
			System.out.println(output[i]);
		}
		int[] output2 = kNums2(nums,4);
		for (int i=output2.length-1;i>0;i--) {
			System.out.println(output2[i]);
		}
				
		
	}

}
