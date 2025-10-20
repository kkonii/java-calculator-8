package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.filter.PatternFilter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final PatternFilter patternFilter;

    public Calculator(InputView inputView, OutputView outputView,
                      PatternFilter patternFilter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.patternFilter = patternFilter;
    }

    public void run() {
        String consoleInput = inputView.getConsoleInput();
        Numbers numbers = patternFilter.filterInput(consoleInput);
        outputView.printResult(numbers.summarize());
    }
}
