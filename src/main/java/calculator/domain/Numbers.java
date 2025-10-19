package calculator.domain;

import calculator.exception.Error;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        numbers.forEach(this::validate);
        this.numbers = numbers;
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    public int summarize() {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }
}
