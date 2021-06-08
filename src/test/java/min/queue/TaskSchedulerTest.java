package min.queue;

import min.CharacterArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TaskSchedulerTest {

    TaskScheduler taskScheduler;

    @BeforeEach
    void setUp() {
        taskScheduler = new TaskScheduler();
    }

    @ParameterizedTest
    @CsvSource({"'AAABBB', 2, 8", "'AAABBB', 0, 6", "'AAAAAABCDEFG', 2, 16"})
    void test(@ConvertWith(CharacterArrayConverter.class) char[] tasks, int n, int output) {
        // when
        int res = taskScheduler.leastInterval(tasks, n);

        // then
        assertThat(res).isEqualTo(output);
    }
}