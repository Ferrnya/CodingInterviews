package chapter4;
import java.util.*;

public class P197_permutation {
	public static List<char[]> permutation (char[] str){
		if(str.length==0 || str==null) {
			return null;
		}
		List<char[]> ret = new LinkedList<>();
		corePermutation(str,ret,0);
		return ret;
	}
	
	public static void corePermutation(char[] str,List<char[]> ret, int bound) {
		if(bound==str.length) {
			ret.add(Arrays.copyOf(str,str.length));
		}
		Set<Character> set = new HashSet<>();
		
		for(int i=bound;i<str.length;i++) {
			//用set排除相同字符
			if(set.add(str[i])) {
				swap(str,bound,i);
				corePermutation(str,ret,bound+1);
				swap(str,bound,i);
			}
		}
	}
	
	public static void swap (char[] str,int x,int y) {
		char temp = str[x];
		str[x] = str[y];
		str[y] = temp;
	}
	
	public static void main(String[] args) {
		char[] str1 = {'a','b','c'};
		List<char[]> list1 = permutation(str1);
		for(char[] item:list1) {
			for(int i=0; i<item.length;i++) {
				System.out.print(item[i]);
			}
			System.out.println();
		}
		System.out.println();
		char[] str2 = {'a','a','b','b'};
		List<char[]> list2 = permutation(str2);
		for(char[] item:list2) {
			for(int i=0; i<item.length;i++) {
				System.out.print(item[i]);
			}
			System.out.println();
		}
	}
}
