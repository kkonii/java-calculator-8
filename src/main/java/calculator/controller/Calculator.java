package calculator.controller;

import calculator.domain.NumberFilter;
import calculator.domain.Numbers;
import calculator.domain.PatternFilter;
import calculator.dto.FilteredInputDto;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final PatternFilter patternFilter;
    private final NumberFilter numberFilter;

    public Calculator(InputView inputView, OutputView outputView,
                      PatternFilter patternFilter, NumberFilter numberFilter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.patternFilter = patternFilter;
        this.numberFilter = numberFilter;
    }

    public void run() {
        String consoleInput = inputView.getConsoleInput();
        FilteredInputDto dto = patternFilter.filterInput(consoleInput);

        System.out.println(dto.delimiterInput());
        System.out.println(dto.numberInput());

        Numbers numbers = numberFilter.filter(dto);

        outputView.printSum(numbers.summarize());
    }
}
