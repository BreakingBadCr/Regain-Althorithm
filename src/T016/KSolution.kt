package T016

fun main(args: Array<String>) {
}

class KSolution {
     fun sum3Closest(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = nums[0] + nums[1] + nums[2]
        for (i in 0 until nums.size - 2) {
            var right = nums.size - 1
            var left = i + 1
            while (left < right) {
                val temp = nums[i] + nums[left] + nums[right]
                if (temp == target) {
                    return temp
                }
                if (Math.abs(temp - target) < Math.abs(result - target)) {
                    result = temp
                }
                if (temp < target) {
                    left++
                } else if (temp > target) {
                    right--
                }
            }
        }
        return result
    }
}