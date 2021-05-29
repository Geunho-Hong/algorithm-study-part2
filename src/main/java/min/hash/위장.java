package min.hash;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(clothes);
        System.out.println("result = " + result);
    }

    public static int solution(String[][] clothes) {
        int result = 1;

        Map<String, Long> clotheMap = Arrays.stream(clothes)
                .collect(groupingBy(c -> c[1], counting()));

        for (Long value : clotheMap.values()) {
            result *= value + 1;
        }

        return result - 1;
    }
}
