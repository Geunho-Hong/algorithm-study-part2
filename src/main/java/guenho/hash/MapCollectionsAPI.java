package guenho.hash;

import java.util.HashMap;
import java.util.Map;

// https://rian-yeji.github.io/algorithm/2019/07/09/algorithm-hashmap-basic.html

public class MapCollectionsAPI {
    public static void main(String[] args) {

        /**
         * V getOrDefault(Object key, V defaultValue)
         * key 값을 가져오고 만약 값이 없거나 null 이면 default 값을 가져온다
         * 단순히 결과값만 가져오고 map 에 추가되지 않는다.
         */

        Map<String, String> map = new HashMap<>();

        System.out.println(map.getOrDefault("grayson", "defaultValue"));

        map.put("grayson", "existValue");
        System.out.println(map.getOrDefault("grayson", "defaultValue"));


        /**
         * V putIfAbsent(Object key , V value )
         * key 값이 없거나 null 이면 값을 추가 한다
         * map 에 새롭게 추가된다
         */

        map.putIfAbsent("test","12345");
        map.putIfAbsent("test","55555");

        System.out.println("map = " + map.toString());

        /**
         * V computeIfAbsent(K key, Function mappingFunction)
         * 1. Key 값에 대해 어떻게 연산할지 정의 한다
         * 2. Key 값이 없을 경우에만 Function 이 수행 된다
         */

        Map<String,Integer> computeMap = new HashMap<>();
        computeMap.put("A",5);

        computeMap.computeIfAbsent("A" , key -> 10);
        computeMap.computeIfAbsent("B" , key -> 10);

        System.out.println("computeMap = " + computeMap.toString());


        /**
         * V computeIfPresent(K key, Function mappingFunction)
         * 1. Key 값에 대해 어떻게 연산할지 정의 한다
         * 2. Key 값이 있을 경우에만 Function 이 수행 된다
         */

        Map<String,Integer> computePresentMap = new HashMap<>();

        computePresentMap.put("A",5);

        computePresentMap.computeIfPresent("A", (key,value) -> value * value);
        computePresentMap.computeIfPresent("B", (key,value) -> 10);

        System.out.println("computeIfPresent = " + computePresentMap.toString());
    }
}
