package chapter5;
import java.util.*;

public class P214_medianNum {
	//ArrayList需要用包装类声明
	List<Double> maxHeap = new ArrayList<Double>();
	List<Double> minHeap = new ArrayList<Double>();
	
	public P214_medianNum(){
		maxHeap.add(0.0);
		minHeap.add(0.0);
	}
	
	public void addNum(double num) {
		if(maxHeap.size()==minHeap.size()) {
			if(minHeap.size()<=1 || num<minHeap.get(1)) {
				addItemMaxHeap(num);
			}else {
				addItemMaxHeap(minHeap.get(1));
				minHeap.set(1, num);
				adjustMinHeap(1);
			}
		}
		else {
			if(num>=maxHeap.get(1)) {
				addItemMinHeap(num);
			}else {
				addItemMinHeap(maxHeap.get(1));
				maxHeap.set(1, num);
				adjustMaxHeap(1);
			}
			
		}
	}
	
	private void addItemMaxHeap(double num) {
		maxHeap.add(num);
		int index = maxHeap.size()-1;
		while(index>1 && maxHeap.get(index)>maxHeap.get(index/2)) {
			double temp = maxHeap.get(index);
			maxHeap.set(index,maxHeap.get(index/2));
			maxHeap.set(index/2,temp);
			index = index/2;
		}
	}
	
	private void adjustMaxHeap(int index) {
		int left = index*2;
		int right = left+1;
		int max = index;
		if (left<maxHeap.size() && maxHeap.get(left)>maxHeap.get(max)) {
			max = left;
		}
		if (right<maxHeap.size() && maxHeap.get(right)>maxHeap.get(max)) {
			max = right;
		}
		if(max!=index) {
			double temp = maxHeap.get(index);
			maxHeap.set(index, maxHeap.get(max));
			maxHeap.set(max, temp);
			adjustMaxHeap(max);
		}

	}
	
	private void addItemMinHeap(double num) {
		minHeap.add(num);
		int index = minHeap.size()-1;
		while(index>1 && minHeap.get(index)<minHeap.get(index/2)) {
			double temp = minHeap.get(index);
			minHeap.set(index,minHeap.get(index/2));
			minHeap.set(index/2,temp);
			index = index/2;
		}
	}
	
	private void adjustMinHeap(int index) {
		int left = index*2;
		int right = left+1;
		int min = index;
		if (left<minHeap.size() && minHeap.get(left)<minHeap.get(min)) {
			min = left;
		}
		if (right<minHeap.size() && minHeap.get(right)<minHeap.get(min)) {
			min = right;
		}
		if(min!=index) {
			double temp = minHeap.get(index);
		    minHeap.set(index, minHeap.get(min));
			minHeap.set(min, temp);
			adjustMaxHeap(min);
		}

	}
	
	public double findMedian() {
		double middle = 0.0;
		if(maxHeap.size()==minHeap.size()) {
			middle = (maxHeap.get(1)+minHeap.get(1))/2;
		}else {
			middle = maxHeap.get(1);
		}
		return middle;
	}
	
	public static void main(String[] args) {
		P214_medianNum num = new P214_medianNum();
		num.addNum(1.0);
		num.addNum(2.0);
		num.addNum(3.0);
		System.out.println(num.findMedian());
	}
	
	

}
