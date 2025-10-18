package calculator.domain;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int summarize() {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }
}
