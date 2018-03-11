package T018

fun main(args: Array<String>) {
    print(KSolution().fourSum(intArrayOf(1, 0, -1, 0, 0, 1, 1, 2, 1, -2, 2), 6))
}

class KSolution {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        var len = nums.size
        if (len < 4) return list
        nums.sort()
        val max = nums[len - 1]
        if (4 * max < target) return list

        for (i in 0 until len - 3) {
            if (nums[i] * 4 > target) break
            if (nums[i] + max * 3 < target) {

                continue
            }
            for (j in i + 1 until len - 2) {
                var left = j + 1
                var right = len - 1
                while (left < right) {
                    val sum = nums[i] + nums[j] + nums[left] + nums[right]
                    when {
                        sum == target -> {
                            val tmp = arrayListOf(nums[i], nums[j], nums[left], nums[right])
                            if (!list.contains(tmp)) {
                                list.add(arrayListOf(nums[i], nums[j], nums[left], nums[right]))
                            }
                            left++
                            right--
                        }
                        sum < target -> left++
                        else -> right--
                    }
                }
            }
        }
        return list
    }

    fun kSum(nums: IntArray, target: Int, k: Int): List<List<Int>> {
        fun twoSum(nums: IntArray, target: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            var left = 0
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[left] + nums[right]
                when {
                    sum == target -> {
                        var list = arrayListOf<Int>(nums[left], nums[right])
                        if (!result.contains(list)) {
                            result.add(list)
                        }
                        while (nums[left] == nums[left + 1] && left < right) {
                            left++
                        }
                        while (nums[right] == nums[right - 1] && left < right) {
                            right--
                        }
                    }
                    sum < target -> {
                        ++left
                    }
                    else -> --right
                }
            }
            return result
        }
        val res = mutableListOf<List<Int>>()
        if ( k == 2){
            res.addAll(twoSum(nums , target))
        }else{

        }
        return res
    }
}