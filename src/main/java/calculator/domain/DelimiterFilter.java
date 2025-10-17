package calculator.domain;

import java.util.Arrays;

public class DelimiterFilter {

    private static final String CUSTOM_FORMAT_MARKS = "//|\\\\n";
    private static final int VALID_CUSTOM_LENGTH = 1;

    public String filterCustomDelimiter(String input) {
        String filtered = Arrays.stream(input.split(CUSTOM_FORMAT_MARKS))
                //잘리고 남은 공백은 버린다
                .filter(f -> !f.isBlank())
                .toList()
                .getFirst();

        validateLength(filtered);

        return filtered;
    }

    private void validateLength(String extracted) {
        if (extracted.length() > VALID_CUSTOM_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 " + VALID_CUSTOM_LENGTH + "개만 입력할 수 있습니다.");
        }
    }
}
