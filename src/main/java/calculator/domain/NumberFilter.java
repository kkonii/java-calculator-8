package calculator.domain;

import calculator.dto.FilteredInputDto;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class NumberFilter {

    public Numbers filter(FilteredInputDto dto) {
        String regex = dto.delimiterInput().stream()
                .map(Pattern::quote)
                .collect(java.util.stream.Collectors.joining("|"));

        List<Integer> splitNumbers = Arrays.stream(dto.numberInput().split(regex))
                .filter(s -> !s.isBlank())
                .map(this::filterNonIntegerValue)
                .toList();

        return new Numbers(splitNumbers);
    }

    private int filterNonIntegerValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 하는 위치에 다른 문자가 입력되었습니다.");
        }
    }
}
