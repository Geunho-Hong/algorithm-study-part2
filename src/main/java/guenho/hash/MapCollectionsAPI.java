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
         * key 값이 없거나 null이면 값을 추가 한다
         * map 에 새롭게 추가된다
         */

        map.putIfAbsent("test","12345");
        map.putIfAbsent("test","55555");

        System.out.println(map.toString());

    }
}
