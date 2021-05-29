package thkim.hash

fun main() {
    testHashMapLevel2Clothes()
}

fun testHashMapLevel2Clothes() {
    val hashLevel2Clothes = HashLevel2Clothes()

//    hashLevel2Clothes.solution(
//            arrayOf(
//                    arrayOf("yellowhat", "headgear"),
//                    arrayOf("bluesunglasses", "eyewear"),
//                    arrayOf("green_turban", "headgear")
//            )
//    )

    hashLevel2Clothes.solution(
            arrayOf(
                    arrayOf("yellowhat", "headgear"),
                    arrayOf("bluesunglasses", "eyewear"),
                    arrayOf("green_turban", "headgear"),
                    arrayOf("smoky_makeup", "face")
            )
    )
}