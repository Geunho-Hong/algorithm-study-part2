package thkim.string

class `Palindrome Partitioning` {
    fun partition(s: String): List<List<String>> {
        val res = ArrayList<List<String>>()
        val list = ArrayList<String>()
        dfs(s, 0, list, res)
        return res
    }

    private fun dfs(s: String, pos: Int, list: MutableList<String>, res: MutableList<List<String>>) {
        if (pos == s.length) {
            res.add(ArrayList<String>(list))
        } else {
            for (i in pos until s.length) {
                if (isPalindrome(s, pos, i)) {
                    list.add(s.substring(pos, i + 1))
                    dfs(s, i + 1, list, res)
                    list.removeAt(list.size - 1)
                }
            }
        }
    }

    private fun isPalindrome(s: String, low: Int, high: Int): Boolean {
        var low = low
        var high = high

        while (low < high) {
            if (s[low++] != s[high--]) return false
        }

        return true
    }
}