package chapter4;
import java.util.*;

public class P199_charCombination {
	
	public static void combination (char[] str){
		if(str.length==0 || str==null) {
			return;
		}
		Arrays.sort(str);
		StringBuilder string = new StringBuilder();
		for(int i=0; i<str.length;i++) {
			coreCombination(str,0,i,string);
		}
	}
	
	//创建StingBuilder对象，对字符串内的每个元素进行循环处理，调用combination函数。对于combination函数，其功能就是将字符串中字符的所有组合输出。
	public static void coreCombination(char[] str, int index, int number,StringBuilder string) {
		if (number == -1) {
            System.out.println(string.toString());
            return;
        }
        if (index == str.length)
            return;
        string.append(str[index]);  //向StringBuilder中添加元素
        coreCombination(str, index + 1, number - 1, string);
        string.deleteCharAt(string.length() - 1);  //在StringBuilder中删除元素
        coreCombination(str, index + 1, number, string);
	}
	
	public static void main(String[] args) {
		char[] str1 = {'a','b','c'};
		combination(str1);
	}

}
