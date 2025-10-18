package calculator.domain;

import calculator.dto.CalculatorDto;
import java.util.Arrays;
import java.util.List;

public class NumberFilter {

    public static Numbers filter(CalculatorDto dto) {
        String regex = "[" + String.join(" | ", dto.delimiter()) + "]";

        List<Integer> splitNumbers = Arrays.stream(dto.numbersInput().split(regex))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .toList();

        return new Numbers(splitNumbers);
    }
}
