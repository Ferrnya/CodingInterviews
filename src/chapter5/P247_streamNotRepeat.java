package chapter5;

public class P247_streamNotRepeat {
	private int[] times;
	private int index;
	public P247_streamNotRepeat(){
		times = new int[256];
		index = 0;
		for(int i=0;i<times.length;i++)
			times[i]=-1;
	}
	
	public void insert(char ch) {
		if(times[ch]==-1)
			times[ch]=index;
		else
			times[ch]=-2;
		index++;
	}
	
	public char find() {
		int minIndex = 256;
		char ret = '\77';
		for(int i=0;i<256;i++) {
			if(times[i]>=0 && times[i]<minIndex) {
				minIndex = times[i];
				ret = (char)i;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		String str = "google";
		P247_streamNotRepeat stream = new P247_streamNotRepeat();
		for(int i=0;i<str.length();i++) {
			stream.insert(str.charAt(i));
			System.out.print(stream.find());
		}
	}

}
