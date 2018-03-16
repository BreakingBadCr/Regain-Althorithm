package T027


fun main(args: Array<String>) {
    print(KSolution().removeElement(intArrayOf(2 , 3 , 5 , 6, 3 , 5) ,5))
}

class KSolution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return if (nums[0] == `val`) 0 else 1
        }
        var tail = 0
        (0 until nums.size)
                .filter { nums[it] != `val` }
                .forEach { nums[tail++] = nums[it] }
        return tail
    }

}