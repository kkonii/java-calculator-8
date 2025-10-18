package calculator.dto;

import java.util.List;

public record FilteredInputDto(List<String> delimiterInput, String numberInput) {
}
