class Solution {
    
    fun getDigitString(s: String): String {
        var target = s.trim()
        
        var numberOfSign = 0
        var foundDigit = false
        var stopIndex = target.length
    
        run check@ {
            target.forEachIndexed { index, element ->
                if (element.isDigit() && !foundDigit ) foundDigit = true
                
                if (foundDigit && !element.isDigit()) {
                    stopIndex = index
                    return@check
                }
                
                if (element == '+' || element == '-') numberOfSign++
            }
        }
    
        target = target.substring(0, stopIndex)
        
        if (target == "" || numberOfSign > 1) return "0"
        if (target.length >= 2 && 
            (target[0]== '+' || target[0]== '-') &&
            target[1].isDigit()
           ) return target
        if (target[0].isDigit()) return target
        
        return "0"
    }

    fun getNumberSign(s: String):Int {
        return if (s[0] == '-') -1 else 1
    }

    fun myAtoi(s: String): Int {
        var digitString = getDigitString(s)
        if (digitString == "" || digitString == "0") return 0
        
        val numberSign = getNumberSign(digitString)
        digitString = digitString.replace("+", "").replace("-", "")
        
        var finalNumber = 0
        digitString.forEach {
            val newDigit = it - '0'
            
            if (finalNumber > Int.MAX_VALUE / 10 ||
                    (finalNumber == Int.MAX_VALUE / 10 && newDigit > Int.MAX_VALUE % 10)
               ) return if (numberSign == -1) Int.MIN_VALUE else Int.MAX_VALUE
            
            finalNumber = newDigit + finalNumber * 10
        }
        return finalNumber * numberSign
    }
}