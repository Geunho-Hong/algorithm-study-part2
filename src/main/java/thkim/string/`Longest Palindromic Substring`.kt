package thkim.string

class `Longest Palindromic Substring` {
    fun longestPalindrome(s: String): String {
        var start = 0
        var end = 0
        for (i in s.indices) {
            val c: Char = s[i]
            var left = i
            var right = i
            while (left >= 0 && s[left] == c) {
                left--
            }
            while (right < s.length && s[right] == c) {
                right++
            }
            while (left >= 0 && right < s.length) {
                if (s[left] != s[right]) {
                    break
                }
                left--
                right++
            }

            left += 1
            if (end - start < right - left) {
                start = left
                end = right
            }
        }

        return s.substring(start, end)
    }
}