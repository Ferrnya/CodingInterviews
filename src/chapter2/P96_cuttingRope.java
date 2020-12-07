package chapter2;

public class P96_cuttingRope {
	public static int cutting(int length) {
		if(length<2) {
			return 0;
		}
		if (length==2) {
			return 1;
		}
		if (length==3) {
			return 2;
		}
		
		//��Ϊ�����Ǵ�0��ʼ�ģ������Ǵ�1��ʼ��
		int[] p = new int[length+1];
		p[0]=0;
		p[1]=1;
		p[2]=2;
		p[3]=3;
		
		int max = 0;
		int temp = 0;
		
		for(int i=4;i<=length;i++) {
			max=0;
			for (int j=1;j<=i/2;j++) {
				temp = p[j]*p[i-j];
				if (temp>max) {
					max = temp;
				}
			}
			p[i]=max;
		}
		
		return p[length];
	}
	
	public static void main(String[] args) {
		System.out.println("The largest product of 10 is "+cutting(10));
		System.out.println("The largest product of 9 is "+cutting(9));
	}

}
