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


        carNamesStr = InputView.readCarNames();
        carNames = Division.divideCarNames(carNamesStr);
        Validation.validateCarNames(carNames);


        attemptCountStr = InputView.readAttemptCount();
        Validation.validateAttemptCount(attemptCountStr);


        attemptCount = Integer.parseInt(attemptCountStr);
        GameController game = new GameController(carNames, attemptCount);

        OutputView.printGameResultHeader();
        game.runGame();

        List<Car> winners = game.determineWinners();
        OutputView.printWinners(winners);
    }
}
