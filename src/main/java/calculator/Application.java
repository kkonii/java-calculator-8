package calculator;

import calculator.controller.Calculator;
import calculator.domain.DelimiterFilter;
import calculator.domain.NumberFilter;
import calculator.domain.PatternFilter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PatternFilter patternFilter = new PatternFilter(new DelimiterFilter());

        Calculator calculator = new Calculator(
                new InputView(),
                new OutputView(),
                patternFilter,
                new NumberFilter());
        calculator.run();
    }
}
