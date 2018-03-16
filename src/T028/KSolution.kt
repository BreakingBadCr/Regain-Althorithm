package T028

fun main(args: Array<String>) {

}

class KSolution {
    public fun strStr(orginal: String, needle: String): Int {
        if (orginal.isEmpty() || needle.isEmpty()) return 0
        var len1 = orginal.length
        var len2 = needle.length

        if (len1 < len2) return -1

        return (0..orginal.length - needle.length).firstOrNull {
            orginal.substring(it, it + needle.length) == needle
        } ?: -1
    }
}