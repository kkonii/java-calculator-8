package calculator.domain;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        numbers.forEach(this::validate);
        this.numbers = numbers;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("숫자는 양수만 입력 가능합니다.");
        }
    }

    public int summarize() {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }
}
