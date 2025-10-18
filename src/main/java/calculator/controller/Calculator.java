package calculator.controller;

import calculator.domain.DelimiterFilter;
import calculator.domain.NumberFilter;
import calculator.domain.Numbers;
import calculator.dto.FilteredInputDto;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final DelimiterFilter delimiterFilter;
    private final NumberFilter numberFilter;

    public Calculator(InputView inputView, OutputView outputView, DelimiterFilter delimiterFilter,
                      NumberFilter numberFilter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.delimiterFilter = delimiterFilter;
        this.numberFilter = numberFilter;
    }

    public void run() {
        String consoleInput = inputView.getInput();
        FilteredInputDto dto = delimiterFilter.filter(consoleInput);

        Numbers numbers = numberFilter.filter(dto);

        outputView.printSum(numbers.summarize());
    }
}
