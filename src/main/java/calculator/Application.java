package calculator;

import calculator.controller.Calculator;
import calculator.domain.filter.DelimiterFilter;
import calculator.domain.filter.InputParser;
import calculator.domain.filter.NumberFilter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser(new DelimiterFilter(), new NumberFilter());

        Calculator calculator = new Calculator(
                new InputView(), new OutputView(), inputParser);

        calculator.run();
    }
}
