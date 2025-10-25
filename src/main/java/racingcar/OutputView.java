package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String GAME_RESULT_HEADER = "\n실행 결과";
    private static final String CAR_POSITION_FORMAT = "%s : %s\n";
    private static final String ADVANCE_MARK = "-";

    public static void printGameResultHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String positionHyphens = getPositionHyphens(car.getPosition());
            System.out.printf(CAR_POSITION_FORMAT, car.getName(), positionHyphens);
        }

        System.out.println();
    }

    private static String getPositionHyphens(int position) {
        return ADVANCE_MARK.repeat(position);
    }

    private static final String FINAL_WINNER_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_DELIMITER = ", ";

    public static void printWinners(List<Car> winners) {
        String winnerNames = getWinnerNames(winners);

        System.out.printf(FINAL_WINNER_FORMAT, winnerNames);
    }

    private static String getWinnerNames(List<Car> winners) {
        List<String> names = new ArrayList<>();

        for (Car winner : winners) {
            names.add(winner.getName());
        }

        return String.join(WINNER_DELIMITER, names);
    }
}
