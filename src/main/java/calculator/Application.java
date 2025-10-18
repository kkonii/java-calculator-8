package calculator;

import calculator.controller.Calculator;
import calculator.domain.DelimiterFilter;
import calculator.domain.NumberFilter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(
                new InputView(),
                new OutputView(),
                new DelimiterFilter(),
                new NumberFilter());
        calculator.run();
    }
}
