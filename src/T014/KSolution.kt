package T014

import com.sun.xml.internal.fastinfoset.util.StringArray

fun main(args: Array<String>) {
    print(KSolution().longestPrefix(arrayOf("ab" , "ab" , "ab" , "ab")))
}

class KSolution {
    fun longestCommonPrefix(strings: Array<String>): String {
        val length = strings.size
        if (strings.isEmpty()) return ""
        if (length == 1) return strings[0]
        (0 until strings[0].length).forEach { i ->
            (1 until strings.size)
                    .filter {
                        println("msg$i:$it")
                        i == strings[it].length || strings[0][i] != strings[it][i]
                    }
                    .forEach {
                        return strings[0].substring(0, i)
                    }
        }
        return strings[0]
    }

    fun longestPrefix(strings: Array<String>):String{
        if (strings.isEmpty())return ""
        if (strings.size == 1 ) return strings[0]
        var minLen = Int.MAX_VALUE
        strings.forEach {
            minLen = Math.min(minLen , it.length)
        }
        (0 until minLen).forEach {i->
            (1 until strings.size).filter {
                strings[0][i] != strings[it][i]
            }.forEach {
                return strings[0].substring(0 , i)
            }
        }
        return strings[0].substring(0 , minLen)
    }
}