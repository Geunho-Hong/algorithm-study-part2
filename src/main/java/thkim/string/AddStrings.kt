package thkim.string

fun main() {
    val result1 = AddStrings().addStrings("11", "123")
    println(result1)
    val result2 = AddStrings().addStrings("456", "77")
    println(result2)
}

class AddStrings {
    fun addStrings(num1: String, num2: String): String {
        var i = num1.length - 1
        var j = num2.length - 1
        var carry = 0

        val sb = StringBuilder()

        while (i >= 0 || j >= 0) {
            var sum = carry

            if (i >= 0) sum += num1[i--] - '0'
            if (j >= 0) sum += num2[j--] - '0'

            sb.append(sum % 10)
            carry = sum / 10
        }

        if (carry != 0) sb.append(carry)
        return sb.reverse().toString()
    }
}