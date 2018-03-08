package T015

import com.sun.xml.internal.fastinfoset.util.StringArray

fun main(args: Array<String>) {
    print(KSolution().sum3(intArrayOf(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6)))
}

class KSolution {
    fun sum3(nums: IntArray): List<List<Int>> {
        nums.sort()
        val set = mutableSetOf<Triple<Int, Int, Int>>()

        for (first in 0 until nums.size - 2) {
            if (nums[first] > 0) {
                break
            }
            val target = 0 - nums[first]
            var left = first + 1
            var right = nums.size - 1
            while (left < right) {
                when {
                    nums[left] + nums[right] == target -> {
                        set.add(Triple(nums[first], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--
                        }
                        left++
                        right--
                    }

                    nums[left] + nums[right] < target -> left++

                    else -> right--

                }
            }
        }
        return mutableListOf<List<Int>>().apply {
            addAll(set.map { arrayListOf(it.first, it.second, it.third) })
        }

    }
}