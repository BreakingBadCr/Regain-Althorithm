package T022

import java.util.*

fun main(args: Array<String>) {
    print(KSolution().generateParenthesis(4))
}

class KSolution {
    fun generateParenthesis(n: Int): List<String> {
        val set = mutableSetOf<String>()
        val list = mutableListOf<String>()
        if (n <= 0) {
            return list
        }
        if (n == 1) {
            return list.apply {
                add("()")
            }
        }

        generateParenthesis(n - 1).forEach { s ->
            val sb = StringBuilder()
            val chars = s.toCharArray()
            for (j in chars.indices) {
                sb.append(chars[j])
                if (chars[j] == '(') {
                    val builder = StringBuilder(sb)
                    builder.append("()")
                    for (k in j + 1 until chars.size) {
                        builder.append(chars[k])
                    }
                    set.add(builder.toString())
                }
            }
            set.add(s + "()")
        }
        println("     ${set.toString()}")
        return list.apply { addAll(set) }
    }

}