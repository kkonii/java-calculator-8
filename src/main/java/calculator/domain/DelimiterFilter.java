package calculator.domain;

import calculator.dto.FilteredInputDto;
import java.util.List;

public class DelimiterFilter {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final int VALID_CUSTOM_LENGTH = 1;

    public FilteredInputDto filterAsDefault(String consoleInput) {
        return new FilteredInputDto(DEFAULT_DELIMITERS, consoleInput);
    }

    public FilteredInputDto filterAsCustom(List<String> splitInput) {
        validateLength(splitInput.getFirst());

        List<String> customDelimiter = List.of(splitInput.getFirst());
        String numbersInput = splitInput.getLast();

        return new FilteredInputDto(customDelimiter, numbersInput);
    }

    private void validateLength(String extractedDelimiter) {
        if (extractedDelimiter.length() > VALID_CUSTOM_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 " + VALID_CUSTOM_LENGTH + "개만 입력할 수 있습니다.");
        }
    }
}
