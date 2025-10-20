package calculator.view;

public class OutputView {

    private static final String RESULT_IS = "결과 : %d";

    public void printResult(int value) {
        System.out.printf(RESULT_IS, value);
    }
}
