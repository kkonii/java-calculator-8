package calculator.domain.filter;

import calculator.dto.FilteredInputDto;
import calculator.exception.Error;
import java.util.Arrays;
import java.util.List;

public class DelimiterFilter {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final int VALID_CUSTOM_LENGTH = 1;
    private static final String CUSTOM_FORMAT_MARKS = "//|\\\\n";

    public FilteredInputDto filterAsDefault(String consoleInput) {
        return new FilteredInputDto(DEFAULT_DELIMITERS, consoleInput);
    }

    public FilteredInputDto filterAsCustom(String consoleInput) {
        List<String> splitInput = Arrays.stream(consoleInput.split(CUSTOM_FORMAT_MARKS))
                .filter(f -> !f.isEmpty())
                .toList();

        String delimiterInput = splitInput.getFirst();
        validateLength(delimiterInput);
        String numbersInput = splitInput.getLast();

        return new FilteredInputDto(List.of(delimiterInput), numbersInput);
    }

    private void validateLength(String extractedDelimiter) {
        if (extractedDelimiter.length() > VALID_CUSTOM_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(Error.INVALID_CUSTOM_DELIMITER_LENGTH.getMessage(), VALID_CUSTOM_LENGTH));
        }
    }
}
