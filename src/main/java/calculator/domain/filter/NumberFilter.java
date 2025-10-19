package calculator.domain.filter;

import calculator.domain.Numbers;
import calculator.dto.FilteredInputDto;
import calculator.exception.Error;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberFilter {

    private static final String MATCHER_REGEX_FORMAT = "[^-?\\d+\\w %s]";

    public Numbers filterValidNumbers(FilteredInputDto dto) {
        String regex = dto.delimiterInput().stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        List<Integer> splitNumbers = Arrays.stream(dto.numberInput().split(regex))
                .filter(s -> !s.isBlank())
                .map(s -> validateNonCustomized(s, regex))
                .map(this::validateNonIntegerValue)
                .toList();

        return new Numbers(splitNumbers);
    }

    private String validateNonCustomized(String value, String regex) {
        Matcher matcher = Pattern.compile(String.format(MATCHER_REGEX_FORMAT, regex)).matcher(value);

        if (matcher.find()) {
            throw new IllegalArgumentException(Error.NON_CUSTOMIZED_DELIMITER.getMessage());
        }

        return value;
    }

    private int validateNonIntegerValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_DELIMITER_OR_CHARACTER.getMessage());
        }
    }
}
