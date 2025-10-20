package calculator.exception;

public enum Error {

    INVALID_DELIMITER_OR_CHARACTER("유효하지 않은 구분자 혹은 문자가 입력되었습니다."),
    NON_CUSTOMIZED_DELIMITER("커스텀으로 지정하지 않은 구분자가 문자열에 포함되었습니다."),
    INVALID_CUSTOM_DELIMITER_LENGTH("커스텀 구분자는 %d개만 입력할 수 있습니다."),
    NUMERIC_TYPE_CAN_NOT_USE("숫자는 커스텀 구분자로 사용할 수 없습니다."),
    INVALID_NUMBER_INPUT("숫자는 양수만 입력 가능합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
