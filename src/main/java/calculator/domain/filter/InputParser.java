package calculator.domain.filter;

import calculator.domain.Numbers;
import calculator.dto.FilteredInputDto;
import calculator.exception.Error;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final Pattern DEFAULT_PATTERN = Pattern.compile("^[-:,\\d]+$");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//(.+)\\\\n(.+)$");

    private final DelimiterFilter delimiterFilter;
    private final NumberFilter numberFilter;

    public InputParser(DelimiterFilter delimiterFilter, NumberFilter numberFilter) {
        this.delimiterFilter = delimiterFilter;
        this.numberFilter = numberFilter;
    }

    public Numbers parseToNumbers(String consoleInput) {
        Matcher defaultMatcher = DEFAULT_PATTERN.matcher(consoleInput);
        Matcher customMatcher = CUSTOM_PATTERN.matcher(consoleInput);

        if (defaultMatcher.matches()) {
            FilteredInputDto filteredDto = delimiterFilter.filterAsDefault(consoleInput);
            return numberFilter.filterValidNumbers(filteredDto);
        }

        if (customMatcher.matches()) {
            FilteredInputDto filteredDto = delimiterFilter.filterAsCustom(consoleInput);
            return numberFilter.filterValidNumbers(filteredDto);
        }

        throw new IllegalArgumentException(Error.INVALID_DELIMITER_OR_CHARACTER.getMessage());
    }
}
