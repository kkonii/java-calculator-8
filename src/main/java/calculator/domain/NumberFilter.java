package calculator.domain;

import calculator.dto.FilteredInputDto;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberFilter {

    private static final String MATCHER_REGEX_FORMAT = "[^\\d\\w %s]";

    public Numbers filter(FilteredInputDto dto) {
        String regex = dto.delimiterInput().stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        List<Integer> splitNumbers = Arrays.stream(dto.numberInput().split(regex))
                .filter(s -> !s.isBlank())
                .map(s -> filterNonCustomized(s, regex))
                .map(this::filterNonIntegerValue)
                .toList();

        return new Numbers(splitNumbers);
    }

    private String filterNonCustomized(String value, String regex) {
        Matcher matcher = Pattern.compile(String.format(MATCHER_REGEX_FORMAT, regex)).matcher(value);

        if (matcher.find()) {
            throw new IllegalArgumentException("커스텀으로 지정하지 않은 구분자가 문자열에 포함되었습니다.");
        }

        return value;
    }

    private int filterNonIntegerValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 하는 위치에 다른 문자가 입력되었습니다.");
        }
    }
}
