package thkim.string

fun main() {
//    val result = AddBinary().addBinary("11", "1")
    val result = AddBinary().addBinary("1010", "1011")
    println(result)
}

class AddBinary {
    fun addBinary(a: String, b: String): String {
        val sb = StringBuilder()

        var i = a.length - 1
        var j = b.length - 1
        var carry = 0

        while (i >= 0 || j >= 0) {
            var sum = carry

            if (j >= 0) sum += b[j--] - '0'
            if (i >= 0) sum += a[i--] - '0'

            sb.append(sum % 2)
            carry = sum / 2
        }

        if (carry != 0) sb.append(carry)
        return sb.reverse().toString()
    }
}