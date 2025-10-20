package calculator.exception;

public enum Error {

    FORMAT_OR_DELIMITER_IS_INVALID("입력 형식이 잘못되었거나 유효하지 않은 구분자가 입력되었습니다."),
    CONTAINS_NON_CUSTOMIZED_DELIMITER("커스텀으로 지정하지 않은 구분자가 문자열에 포함되었습니다."),
    LENGTH_IS_INVALID("커스텀 구분자는 %d글자만 입력할 수 있습니다."),
    NUMERIC_TYPE_CAN_NOT_CUSTOMIZE("숫자는 커스텀 구분자로 지정할 수 없습니다."),
    DEFAULT_DELIMITER_CAN_NOT_CUSTOMIZE("기본 구분자는 커스텀으로 지정할 수 없습니다."),
    IS_INVALID_RANGE("숫자는 양수만 입력 가능합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
