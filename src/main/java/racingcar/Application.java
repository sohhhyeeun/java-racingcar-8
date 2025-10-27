package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNamesStr;
        String[] carNames;
        String attemptCountStr;
        int attemptCount;

        try {
            carNamesStr = InputView.readCarNames();
            attemptCountStr = InputView.readAttemptCount();

            carNames = Division.divideCarNames(carNamesStr);
            Validation.validateCarNames(carNames);
            Validation.validateAttemptCount(attemptCountStr);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " +e.getMessage());

            throw e;
        }

        attemptCount = Integer.parseInt(attemptCountStr);
        GameController game = new GameController(carNames, attemptCount);

        OutputView.printGameResultHeader();
        game.runGame();

        List<Car> winners = game.determineWinners();
        OutputView.printWinners(winners);
    }
}
