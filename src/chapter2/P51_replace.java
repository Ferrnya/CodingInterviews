package chapter2;

/**
 * 替换空格
 * @author Fern
 * 题目描述：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
//解法一 
public class P51_replace {
    public String replaceSpace(StringBuffer str_buffer) {
        String str = str_buffer.toString();
    	if (str==null)
            return str;
        else {
            return str.replace(" ","%20");
        }
    }
    
    public static void main(String[] args){
        P51_replace sol = new P51_replace();
        String str = "We are happy.";
        StringBuffer str_buffer = new StringBuffer(str);
        System.out.print(sol.replaceSpace(str_buffer));
    }
}

/**
 * 解法二
 * public class Solution {
 *   public String replaceSpace(StringBuffer str) {
 *        if(str==null){
 *            return null;
 *        }
 *       StringBuilder newStr = new StringBuilder();
 *        for(int i=0;i< str.length();i++){
 *            if(str.charAt(i)==' '){
 *                newStr.append('%');
 *                newStr.append('2');
 *                newStr.append('0');
 *            }else{
 *                newStr.append(str.charAt(i));
 *            }
 *        }
 *        return newStr.toString();
 *    }
 * }
 */

 /**
  * 注意事项：
  * 1、解法二是书中推荐的方式，即复杂度比较低（但是测试发现两种解法的速度几乎一致）
  */