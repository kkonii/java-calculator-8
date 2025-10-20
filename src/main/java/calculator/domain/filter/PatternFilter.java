package calculator.domain.filter;

import calculator.dto.FilteredInputDto;
import calculator.exception.Error;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFilter {

    private static final Pattern DEFAULT_PATTERN = Pattern.compile("^[-:,\\d]+$");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//(.+)\\\\n(.+)$");

    private final DelimiterFilter delimiterFilter;

    public PatternFilter(DelimiterFilter delimiterFilter) {
        this.delimiterFilter = delimiterFilter;
    }

    public FilteredInputDto filterInput(String consoleInput) {
        Matcher defaultMatcher = DEFAULT_PATTERN.matcher(consoleInput);
        Matcher customMatcher = CUSTOM_PATTERN.matcher(consoleInput);

        if (defaultMatcher.matches()) {
            return delimiterFilter.filterAsDefault(consoleInput);
        }

        if (customMatcher.matches()) {
            return delimiterFilter.filterAsCustom(consoleInput);
        }

        throw new IllegalArgumentException(Error.INVALID_DELIMITER_OR_CHARACTER.getMessage());
    }
}
