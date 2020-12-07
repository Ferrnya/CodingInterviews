package chapter3;

public class P127_strForNum {
	//方法一
	public static boolean isNumeric(String str) {
		if (str.length()==0) {
			return false;
		}
		int index;
		if (str.charAt(0)!='.') {
			index = scanInteger(new StringBuilder(str),0);
			if (index==-1) {return false;}
			if (index==str.length()) {return true;}
			if (str.charAt(index)=='.') {
				if (index==str.length()-1) {return true;}
				index = scanInteger(new StringBuilder(str),index+1);
				if (index==str.length()) {return true;}
			}
			if (str.charAt(index)=='e' ||str.charAt(index)=='E' ) {
				index = scanInteger(new StringBuilder(str),index+1);
				if (index==str.length()) {return true;}
				else {return false;}
			}
			return false;
			
		} 
		else {
			index = scanInteger(new StringBuilder(str),1);
			if (index==-1) {return false;}
			if (index==str.length()) {return true;}
			if (str.charAt(index)=='e' ||str.charAt(index)=='E' ) {
				index = scanInteger(new StringBuilder(str),index+1);
				if (index==str.length()-1) {return true;}
				else {return false;}
			}
			return false;
		}		
	}
	
	
	public static int scanInteger(StringBuilder str, int strIndex) {
		if (strIndex>=str.length()) {
			return -1;
		}		
		if(str.charAt(strIndex)=='+'||str.charAt(strIndex)=='-'){
			return scanUnsignedInteger(str,strIndex+1);
		}
		else {
			return scanUnsignedInteger(str,strIndex);
		}		
	}
	
	public static int scanUnsignedInteger(StringBuilder str, int strIndex) {
		int origin = strIndex;
		while(str.charAt(strIndex)>='0'&&str.charAt(strIndex)<='9') {
			strIndex++;
			if (strIndex == str.length()) {
				return strIndex;
			}
		}
		if (origin == strIndex) {
			strIndex = -1;
		}
		return strIndex;
	}
	
	
	//方法二 正则表达式
	//[] 字符集合
	//() 分组
	//? 重复0-1次
	//+ 重复1-n次
	//* 重复0-n次
	//. 任意字符
	//  \\. 转义后的.
	//  \\d 数字
	//应用string的match方法
    public static boolean regularMatch(String str) {
    	if (str.length()==0) {
			return false;
		}
    	return str.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
	
	
	public static void main(String[] args){
        System.out.println(isNumeric("+100"));//true
        System.out.println(isNumeric("5e2")); //true
        System.out.println(isNumeric("-123"));//true
        System.out.println(isNumeric("3.1416"));//true
        System.out.println(isNumeric("-1E-16"));//true
        System.out.println(isNumeric(".6"));//true
        System.out.println(isNumeric("6."));//true
        System.out.println(isNumeric("12e"));//false
        System.out.println(isNumeric("1a3.14"));//false
        System.out.println(isNumeric("1.2.3"));//false
        System.out.println(isNumeric("+-5"));//false
        System.out.println(isNumeric("12e+5.4"));//false
        System.out.println(regularMatch("+100"));//true
        System.out.println(regularMatch("5e2")); //true
    }

}
