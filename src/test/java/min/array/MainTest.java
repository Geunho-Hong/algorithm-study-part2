package min.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("1")
                .append("2")
                .append("3")
                .append("4");

        System.out.println(sb);

        sb.delete(1, 2);

        System.out.println(sb);

        sb.replace(1, 2, "2");

        System.out.println(sb);
    }

}