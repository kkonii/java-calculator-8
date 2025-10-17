package calculator.dto;

import java.util.List;

public record CalculatorDto(List<String> delimiter, String numbersInput) {
}
