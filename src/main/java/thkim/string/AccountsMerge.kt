package thkim.string

import java.util.*

fun main() {
    val result = AccountsMerge().accountsMerge(
        listOf(
            listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            listOf("John", "johnsmith@mail.com", "john00@mail.com"),
            listOf("Mary", "mary@mail.com"),
            listOf("John", "johnnybravo@mail.com")
        )
    )

    println(result.toString())
}

class AccountsMerge {
    private val graph = HashMap<String, MutableSet<String>>()
    private val name = HashMap<String, String>()

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        buildGraph(accounts)

        val visited = HashSet<String>()
        val res: MutableList<List<String>> = LinkedList()

        for (email in name.keys) {
            val list = LinkedList<String>()

            if (visited.add(email)) {
                dfs(graph, email, visited, list)
                list.sort()
                list.add(0, name[email]!!)
                res.add(list)
            }
        }

        return res
    }

    private fun buildGraph(accounts: List<List<String>>) {
        for (account in accounts) {
            val userName = account[0]

            for (i in 1 until account.size) {
                if (graph.containsKey(account[i]).not()) {
                    graph[account[i]] = HashSet()
                }
                name[account[i]] = userName

                if (i == 1) continue

                graph[account[i]]?.add(account[i - 1])
                graph[account[i - 1]]?.add(account[i])
            }
        }
    }

    private fun dfs(
        graph: Map<String, Set<String>>,
        email: String,
        visited: MutableSet<String>,
        list: MutableList<String>
    ) {
        list.add(email)
        for (next in graph[email]!!) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list)
            }
        }
    }
}