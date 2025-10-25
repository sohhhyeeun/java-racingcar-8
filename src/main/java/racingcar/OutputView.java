package racingcar;

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
}
