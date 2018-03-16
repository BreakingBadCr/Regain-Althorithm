package T026

fun main(args: Array<String>) {
    print(KSolution().removeDuplicates(intArrayOf(1, 1 , 2 ,3 , 3 , 4 , 5 , 5)))
}

class KSolution {
     fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var i = 0
         (1 until nums.size)
                 .asSequence() //Lazy Evaluation -> Streams in Java8
                 .filter {
                     nums[i] != nums[it]
                 }
                 .forEach {
                     nums[++i] = nums[it] }
        return i + 1
    }
}