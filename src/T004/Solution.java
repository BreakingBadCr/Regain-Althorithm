package T004;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = new int[]{1 , 5 , 5 , 6} ;
        int[] nums2 = new int[]{2 , 3 , 5, 7} ;
        System.out.print(solution.findMedianSortedArrays(nums1 , nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (solute(nums1, 0, nums2, 0, len / 2) + solute(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
        return solute(nums1, 0, nums2, 0, (len + 1) / 2);
    }

    private int solute(int[] firstNums, int firstStart, int[] secondNums, int secondStart, int k) {
        if (firstStart >= firstNums.length) return secondNums[secondStart + k - 1];
        if (secondStart > secondNums.length) return firstNums[firstStart + k - 1];
        if (k == 1) return Math.min(firstNums[firstStart], secondNums[secondStart]);

        int location1 = firstStart + k / 2 - 1;
        int location2 = secondStart + k / 2 - 1;
        int mid1 = location1 < firstNums.length ? firstNums[location1] : Integer.MAX_VALUE;
        int mid2 = location2 < secondNums.length ? secondNums[location2] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return solute(firstNums, firstStart + k / 2, secondNums, secondStart, k - k / 2);
        }
        return solute(firstNums, firstStart, secondNums, secondStart + k / 2, k - k / 2);
    }
}
