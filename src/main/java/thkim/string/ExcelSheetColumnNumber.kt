package thkim.string

fun main() {
    println(ExcelSheetColumnNumber().titleToNumber("AB"))
    println(ExcelSheetColumnNumber().titleToNumber("ABC"))
}

class ExcelSheetColumnNumber {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        for (i in columnTitle.indices) {
            result = (result * 26) + (columnTitle[i] - 'A' + 1)
        }
        return result
    }
}