package T017

fun main(args: Array<String>) {
    print(KSolution().letterCombinations("254"))
}

class KSolution {

    fun letterCombinations(digits: String): List<String> {
        val map = arrayOf(" " , "" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val result = mutableListOf<String>()
        if (digits.isEmpty()){
            return emptyList()
        }
        if (digits.length == 1){
            map[Integer.valueOf(digits)].toCharArray()
                    .mapTo(result){
                        it.toString()
                    }
            return result
        }

        val list = letterCombinations(digits.substring(1 , digits.length))
        val sb = StringBuilder()
        for (c in map[Integer.valueOf(digits.substring(0,1))].toCharArray()){
            for (s in list){
                sb.append(c.toString()).append(s)
                result.add(sb.toString())
                sb.setLength(0)
            }
        }
        return result
    }
}