package chapter2;

public class P44_search {
    public boolean Find(int target, int [][] array) {
        if (array.length==0 || array[0].length==0 ||array==null)
            return false;
        int max_row_index = array.length - 1;
        int cur_row = 0;
        int max_line_index = array[0].length - 1;
        int cur_line = max_line_index;
        while(true){
            if (cur_row>max_row_index||cur_line<0||cur_line>max_line_index)
                return false;
            if (array[cur_row][cur_line]==target)
                return true;
            else if (array[cur_row][cur_line]>target)
                cur_line--;
            else
                cur_row++;      
        }
    }
    public static void main(String[] args){
        P44_search sol = new P44_search();
        int[][] array = {{1,3,5,7},{3,5,7,9},{5,7,9,11},{7,9,11,13}};
        int target = 1;
        boolean include = sol.Find (target, array);
        System.out.print(include);
    }   
}
