package T011

fun main(args: Array<String>) {
    print(KSolution().maxArea(intArrayOf(2 ,4 ,5 ,2 ,6 ,1)))
}

class KSolution {
    fun maxArea(height: IntArray): Int {
        if (height.size < 2) {
            return 0
        }
        var low = 0
        var high = height.size - 1
        var maxCapacity = 0
        while (low < high) {
            val h = Math.min(height[low], height[high])
            maxCapacity = Math.max(maxCapacity, (high - low) * h)
            while (height[low] <= h && low < high) ++low
            while (height[high] <= h && low < high) --high
        }
        return maxCapacity
    }
}