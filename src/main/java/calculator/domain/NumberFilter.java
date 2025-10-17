package calculator.domain;

import calculator.dto.CalculatorDto;
import java.util.Arrays;
import java.util.List;

public class NumberFilter {

    public static List<Integer> filter(CalculatorDto dto) {
        String regex = "[" + String.join(" | ", dto.delimiter()) + "]";

        return Arrays.stream(dto.numbersInput().split(regex))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .toList();
    }
}
