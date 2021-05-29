package min.hash;

import java.util.HashMap;
import java.util.Map;

public class HashExample {

    private static final Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            hashMap.put("http", 80);
            hashMap.put("ssh", 22);
            hashMap.put("dns", 53);
            hashMap.put("telnet", 23);
            hashMap.put("ftp", 21);

            hashMap.forEach((key, value) -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(key + "=" + value);
            });
        });

        thread.start();
        Thread.sleep(1000);
        hashMap.put("dhcp", 67);
        System.out.println("MainThead end!!");
    }

    static class TestVO {
        private String name;
        private Integer age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TestVO)) return false;

            TestVO testVO = (TestVO) o;

            if (!name.equals(testVO.name)) return false;
            return age.equals(testVO.age);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age.hashCode();
            return result;
        }
    }


}