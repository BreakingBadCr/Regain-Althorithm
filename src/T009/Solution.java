package T009;

public class Solution {

    public static void main(String[] args) {
        System.out.print(new Solution().isPalinNumber(1234321));
    }

    public boolean isPalindromeNumber(int x) {
        if (x < 0) return false;
        int copyX = x, reverse = 0;
        while (copyX > 0) {
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }
        return reverse == x;
    }

    public boolean isPalinNumber(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverse = 0;
        while (x > halfReverse) {
            halfReverse = halfReverse * 10 + x % 10;
            x /= 10;

        }
        return halfReverse == x || halfReverse / 10 == x;
    }
}
