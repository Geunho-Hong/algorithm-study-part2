package thkim.hash

import java.util.HashMap

class HashLevel2Clothes {

    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        val hash: HashMap<String, Int> = hashMapOf()

        clothes.forEach {
            hash[it[1]] = hash.getOrDefault(it[1], 0) + 1
        }

        /*
         * 각 종류의 옷은 하나를 입거나, 입지 않는 선택지가 있기 때문에 옷의 개수에 선택지 1개를 추가한다.
         * 또한 옷을 고르는 선택은 동시에 일어나는 일이기 때문에, 각 옷들을 곱해 경우의 수를 계산한다.
         * 이때, 하나도 안입은 선택지는 없으므로 경우의 수 하나를 뺀다.
         */
        hash.values.forEach { count ->
            answer *= (count + 1)
        }

        return answer - 1
    }

    fun bestSolution(clothes: Array<Array<String>>): Int {
        return clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) } - 1
    }

}