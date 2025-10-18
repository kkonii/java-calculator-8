package calculator.domain;

import calculator.dto.FilteredInputDto;
import java.util.Arrays;
import java.util.List;

public class NumberFilter {

    public static Numbers filter(FilteredInputDto dto) {
        String regex = "[" + String.join(" | ", dto.delimiterInput()) + "]";

        List<Integer> splitNumbers = Arrays.stream(dto.numberInput().split(regex))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .toList();

        return new Numbers(splitNumbers);
    }
}
