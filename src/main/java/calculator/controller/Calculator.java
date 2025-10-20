package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.filter.InputParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public Calculator(InputView inputView, OutputView outputView,
                      InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void run() {
        String consoleInput = inputView.getConsoleInput();
        Numbers numbers = inputParser.parseToNumbers(consoleInput);
        outputView.printResult(numbers.summarize());
    }
}
