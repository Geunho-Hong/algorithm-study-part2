package thkim.week0919

fun main() {
    val result =`단어 변환`().solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
    println(result)
}

class `단어 변환` {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0

        val visited = BooleanArray(words.size)

        fun dfs(begin: String, count: Int = 0) {
            if (begin == target) {
                answer = count
                return
            }

            for ((i, string) in words.withIndex()) {
                if (visited[i]) continue

                var matchCount = 0
                for ((j, char) in begin.withIndex()) {
                    if (char == string[j]) matchCount += 1
                    if (j - matchCount >= 2) continue
                }

                if (matchCount == begin.length - 1) {
                    visited[i] = true
                    dfs(string, count + 1)
                    visited[i] = false
                }
            }
        }

        dfs(begin)

        return answer
    }
}