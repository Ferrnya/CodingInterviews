package chapter2;

/**
 * �滻�ո�
 * @author Fern
 * ��Ŀ��������ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
//�ⷨһ 
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
 * �ⷨ��
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
  * ע�����
  * 1���ⷨ���������Ƽ��ķ�ʽ�������ӶȱȽϵͣ����ǲ��Է������ֽⷨ���ٶȼ���һ�£�
  */