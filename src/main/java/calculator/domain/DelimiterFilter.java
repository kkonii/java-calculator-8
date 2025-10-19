package calculator.domain;

import calculator.dto.FilteredInputDto;
import java.util.List;

public class DelimiterFilter {

    private static final String DEFAULT_FORMAT_MARKS = "^[가-힣A-Za-z0-9,:]+$";
    private static final int VALID_CUSTOM_LENGTH = 1;

    public FilteredInputDto filterByDefault(String input) {
        validateDefaultFormat(input);
        List<String> defaultDelimiters = List.of(",", ":");

        return new FilteredInputDto(defaultDelimiters, input);
    }

    public FilteredInputDto filterByCustom(List<String> splitInput) {
        validateLength(splitInput.getFirst());

        List<String> customDelimiter = List.of(splitInput.getFirst());
        String numbersInput = splitInput.getLast();

        return new FilteredInputDto(customDelimiter, numbersInput);
    }

    private void validateDefaultFormat(String numberInput) {
        if (!numberInput.matches(DEFAULT_FORMAT_MARKS)) {
            throw new IllegalArgumentException("기본 구분자 외의 문자는 커스텀 형식으로 입력해 주세요.");
        }
    }

    private void validateLength(String extracted) {
        if (extracted.length() > VALID_CUSTOM_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 " + VALID_CUSTOM_LENGTH + "개만 입력할 수 있습니다.");
        }
    }
}
