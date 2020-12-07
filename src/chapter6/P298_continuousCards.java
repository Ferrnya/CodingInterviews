package chapter6;

public class P298_continuousCards {
	public static boolean continuous(int[] cards) {
		if(cards==null || cards.length!=5) 
			return false;
		int[] result = new int[14];
		for(int i=0;i<cards.length;i++) {
			if(cards[i]>13||cards[i]<0)
				return false;
			result[cards[i]]++;
		}  
		
		int start=1;
		while(result[start]==0)
			start++;
		int king=result[0];
		
		for(int i=start;i<start+5;i++) {
			if(i>13)
				break;
			if(result[i]>1 || result[i]<0)
				return false;
			else if(result[i]==0) {
				if(king==0)
					return false;
				else
					king--;
			}
		}
		return true;
			
	}
	
	public static void main(String[] args) {
		System.out.println(continuous(new int[]{1,0,0,5,4}));
	}

}
