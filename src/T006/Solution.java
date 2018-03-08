package T006;

public class Solution {
    public static void main(String[] args){
        System.out.print(new Solution().ordinaryConvert("happniess" , 3));
    }

    public String ordinaryConvert(String s , int rowCounts){
        if (rowCounts <= 1) return s;
        int length = s.length();
        char[] chars = s.toCharArray();
        int cycle = 2 * (rowCounts -1) ;
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0;  j < length ; j += cycle){
            stringBuilder.append(chars[j]);
        }
        for (int i = 1 ; i < rowCounts - 1 ;i++){
            int step = 2 * i ;
            for (int j = i ; j < length ; j += step){
                stringBuilder.append(chars[j]);
                step = cycle - step;
            }
        }
        for (int j = rowCounts - 1 ; j < length ; j += cycle){
            stringBuilder.append(chars[j]);
        }
        return stringBuilder.toString();
    }


}
