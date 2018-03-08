package T005;

public class Solution {

    public static void main(String[] args){
        String resource = "abareqwqefefd" ;
        String result = new OrdinaryAlgorithm().getLongestPalindrome(resource) ;
        if (result != null){
            System.out.print(result);
        }
    }
    private static class OrdinaryAlgorithm implements LongestPalindrome {

        @Override
        public String getLongestPalindrome(String resource) {
            int length = resource.length();
            if (length <= 1) return resource;
            int start = 0, end = 0;
            char[] chars = resource.toCharArray();
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
                for (int j = 0; j < i; j++) {
                    if (j + 1 == i) {
                        dp[j][i] = chars[i] == chars[j];
                    } else {
                        dp[j][i] = dp[j + 1][i - 1] && chars[j] == chars[i];
                    }
                    if (dp[j][i] && i - j > end - start){
                        start = j ;
                        end = i ;
                    }
                }
            }
            return resource.substring(start , end + 1);
        }
    }

    private class ManacherAlgorithm implements LongestPalindrome {

        @Override
        public String getLongestPalindrome(String resource) {

            return null;
        }
    }

    private interface LongestPalindrome {
        String getLongestPalindrome(String resource);
    }
}
