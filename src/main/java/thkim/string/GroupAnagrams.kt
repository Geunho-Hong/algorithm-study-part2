package thkim.string


fun main() {
    val result1 = GroupAnagrams().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    println(result1)
}

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) return arrayListOf()
        val map: MutableMap<String, MutableList<String>> = HashMap()
        for (s in strs) {
            val ca = CharArray(26)
            for (c in s.toCharArray()) {
                ca[c - 'a']++
            }
            val keyStr = String(ca)
            if (!map.containsKey(keyStr)) {
                map[keyStr] = ArrayList()
            }
            map[keyStr]?.add(s)
        }
        return ArrayList<List<String>>(map.values)
    }
}