package thkim.hash

class HashLevel3Genres {

    // https://programmers.co.kr/learn/courses/30/lessons/42579?language=kotlin
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] } // { classic = [0, 2, 3], pop = [1, 4]} (Map 형태로 변환)
            .toList() // [(classic, [0,2,3]),(pop,[1,4])] Type : List<Pair<String, Int>> (List로 변환)
            .sortedByDescending {
                it.second.sumBy {
                    plays[it]
                }
            } // [(pop, [1,4]), (classic, [0,2,3])] Type : List<Pair<String, Int>> (장르 재생 횟수 합산 결과 정렬)
            .map {
                it.second.sortedByDescending {
                    plays[it]
                }.take(2)
            } // [[4,1],[3,0]] Type : List<Pair<String, Int>> (장르 내부 재생 횟수 정렬)
            .flatten() // [4, 1, 3, 0] Type : List<Pair<String, Int>> (하나의 리스트로 변환)
            .toIntArray() // [4, 1, 3, 0] Type : IntArray
    }

}