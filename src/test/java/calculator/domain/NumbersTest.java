package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("[성공] 숫자들의 합을 구하는 데에 성공한다")
    void sum_numbers() {
        Numbers nums = new Numbers(List.of(1, 2, 3, 4));
        Assertions.assertThat(nums.summarize()).isEqualTo(10);
    }

    @Test
    @DisplayName("[예외] 음수값에 대해 에외를 발생시킨다")
    void throw_when_not_positive() {
        Assertions.assertThatThrownBy(() -> new Numbers(List.of(1, -2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[예외] 0값에 대해 에외를 발생시킨다")
    void throw_when_zero() {
        Assertions.assertThatThrownBy(() -> new Numbers(List.of(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
