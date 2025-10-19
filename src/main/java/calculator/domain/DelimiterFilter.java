package calculator.domain;

import calculator.dto.FilteredInputDto;
import java.util.Arrays;
import java.util.List;

public class DelimiterFilter {

    private static final String CUSTOM_FORMAT_MARKS = "//|\\\\n";
    private static final String DEFAULT_FORMAT_MARKS = "^[가-힣A-Za-z0-9,:]+$";
    private static final int VALID_CUSTOM_LENGTH = 1;
    private static final int DEFAULT_FORMAT_STATUS = 1;
    private static final int CUSTOM_FORMAT_STATUS = 2;

    public FilteredInputDto filter(String input) {
        List<String> splitInput = Arrays.stream(input.split(CUSTOM_FORMAT_MARKS))
                //잘리고 남은 공백은 버린다
                .filter(f -> !f.isEmpty())
                .toList();

        if (splitInput.size() == DEFAULT_FORMAT_STATUS) {
            return filterByDefault(splitInput);
        }

        if (splitInput.size() == CUSTOM_FORMAT_STATUS) {
            //커스텀 구분자 형식으로 작성된 문자열
            return filterByCustom(splitInput);
        } else {
            //잘못된 입력 형식
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }
    }

    private FilteredInputDto filterByDefault(List<String> splitInput) {
        String numbersInput = splitInput.getFirst();
        validateDefaultFormat(numbersInput);
        List<String> defaultDelimiters = List.of(",", ":");

        return new FilteredInputDto(defaultDelimiters, numbersInput);
    }

    private FilteredInputDto filterByCustom(List<String> splitInput) {
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
