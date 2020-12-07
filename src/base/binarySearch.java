//实现二分查找代码
//输入的数组必须是有序的 中间使用 int mid = lo+(hi-lo)/2
package base;

public class binarySearch {
	public static int rank (int[] array, int key) {
		int lo = 0;
		int hi = array.length-1;
		while (lo<hi) {
			int mid = lo+(hi-lo)/2;
			if (key>array[mid]) { lo = mid+1;}
			else if (key<array[mid]) { hi = mid-1;}
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		int key = 5;
		System.out.println(rank(array,key));
	}
	

}
