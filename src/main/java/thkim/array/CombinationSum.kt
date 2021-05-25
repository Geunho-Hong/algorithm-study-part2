package thkim.array

class CombinationSum {

    // Backtracking
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = ArrayList<List<Int>>()

        fun dfs(start: Int, sum: Int, path: ArrayList<Int>) {
            if (sum == target) {
                res.add(path.toList())
                return
            }

            for (i in start until candidates.size) {

                if (sum + candidates[i] > target) continue
                path.add(candidates[i])
                dfs(i, sum + candidates[i], path)
                path.removeAt(path.size - 1)
            }
        }

        dfs(0, 0, arrayListOf())
        return res
    }
}