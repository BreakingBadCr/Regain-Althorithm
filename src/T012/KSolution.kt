package T012

fun main(args: Array<String>) {
    print(KSolution().intToRoman(18))
}

class KSolution {
    val roman = charArrayOf('M', 'D', 'C', 'L', 'X', 'V', 'I')
    val value = intArrayOf(1000, 500, 100, 50, 10, 5, 1)

    fun intToRoman(num: Int): String {
        var copyNum = num
        val sb = StringBuilder()

        var n = 0
        while (n < value.size) {
            val x = copyNum / value[n]
            when {
                x < 4 -> for (i in 1..x) {
                    sb.append(roman[n])
                }
                x == 4 -> sb.append(roman[n]).append(roman[n - 1])
                x < 9 -> {
                    sb.append(roman[n - 1])
                    for (i in 6..x) {
                        sb.append(roman[n])
                    }
                }
                x == 9 -> sb.append(roman[n]).append(roman[n - 2])
            }
            copyNum %= value[n]
            n += 2
        }
        return sb.toString()
    }
    fun romanToInt(roman:String):Int{
        var result = 0
        val dict = mapOf(
                Pair('I' , 1),
                Pair('V' , 5),
                Pair('X' , 10),
                Pair('L' , 50),
                Pair('C' , 100),
                Pair('D' , 500),
                Pair('M' , 1000))
        val chars = roman.toCharArray()
        var i = 0
        while (i < chars.size){
            if (i + 1 < chars.size
                    && (dict[chars[i + 1]]!! > dict[chars[i]]!!)
                    && (chars[i] == 'I' || chars[i] == 'X' || chars[i] == 'C')){
                result+= dict[chars[i+ 1]]!! - dict[chars[i]]!!
                i++
            }
            else{
                result += dict[chars[i]]!!

            }
            i++
        }

        return result
    }
}