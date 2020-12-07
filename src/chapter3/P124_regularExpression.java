package chapter3;

public class P124_regularExpression {
	public static boolean regularMatch(String str, String pattern) {
		if (str.length()==0 || pattern.length()==0) 
			return false;
	
		return matchCore(new StringBuilder(str), 0, new StringBuilder(pattern), 0);
	}
	
	public static boolean matchCore(StringBuilder str, int strIndex, StringBuilder pattern, int patternIndex) {
        //���ƥ�䴮��ģʽ����ƥ�����
        if(strIndex==str.length() && patternIndex==pattern.length())
            return true;
        if(strIndex!=str.length() && patternIndex==pattern.length())
            return false;
        if(strIndex==str.length() && patternIndex!=pattern.length()) {
            if(patternIndex+1<pattern.length()&&pattern.charAt(patternIndex+1)=='*')
                return matchCore(str,strIndex,pattern,patternIndex+2);
            else
                return false;
        }
        //���ģʽ���ĵڶ����ַ�����*�����Ѿ�ֻʣһ���ַ���
        if(patternIndex==pattern.length()-1|| pattern.charAt(patternIndex+1)!='*'){
            if(pattern.charAt(patternIndex)=='.' || pattern.charAt(patternIndex)==str.charAt(strIndex))
                return matchCore(str,strIndex+1,pattern,patternIndex+1);
            else
                return false;
        }
        //���ģʽ���ĵڶ����ַ���*
        else{
            if(pattern.charAt(patternIndex)=='.'||pattern.charAt(patternIndex)==str.charAt(strIndex))
                return matchCore(str,strIndex+1,pattern,patternIndex)
                        ||matchCore(str,strIndex+1,pattern,patternIndex+2)
                        ||matchCore(str,strIndex,pattern,patternIndex+2);
            else
                return matchCore(str,strIndex,pattern,patternIndex+2);
        }
	}
	
	public static void main(String args[]) {
		System.out.println(regularMatch("aaa","a.a"));
		System.out.println(regularMatch("aaa","ab*ac*a"));
		System.out.println(regularMatch("aaa","aa.a"));
		System.out.println(regularMatch("aaa","ab*a"));
	}

}
