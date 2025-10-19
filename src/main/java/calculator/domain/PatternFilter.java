package calculator.domain;

import calculator.dto.FilteredInputDto;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFilter {

    private static final Pattern DEFAULT_PATTERN = Pattern.compile("^[가-힣A-Za-z0-9,:]+$");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//(.+)\\\\n(.+)$");
    private static final String CUSTOM_FORMAT_MARKS = "//|\\\\n";

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
            List<String> splitInput = Arrays.stream(consoleInput.split(CUSTOM_FORMAT_MARKS))
                    .filter(f -> !f.isEmpty())
                    .toList();

            return delimiterFilter.filterAsCustom(splitInput);
        }

        throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
    }
}
