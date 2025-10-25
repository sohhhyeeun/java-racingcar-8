package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNamesStr = InputView.readCarNames();
        String attemptCountStr = InputView.readAttemptCount();

        String[] carNames = Division.divideCarNames(carNamesStr);

        try {
            Validation.validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
