class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs[0]
        
        strs.sortBy { it.length }
        
        var prefix = ""
        run check@{
            strs.forEachIndexed { index, element ->
                if (index == 0) {
                    prefix = element
                } else {
                    for (charIndex in prefix.indices) {
                        if (prefix[charIndex] != element[charIndex]) {
                            prefix = prefix.substring(0 until charIndex)
                            if (charIndex == 0) return@check else return@forEachIndexed
                        } 
                    }
                }
            }
        }

        return prefix
    }
}