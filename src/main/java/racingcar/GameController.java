package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Car> cars;
    private final int attemptCount;

    public GameController(String[] carNames, int attemptCount) {
        this.cars = createCars(carNames);
        this.attemptCount = attemptCount;
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> newCars = new ArrayList<>();

        for (String carName : carNames) {
            newCars.add(new Car(carName));
        }

        return newCars;
    }

    public void runGame() {
        for (int i = 0; i < attemptCount; i++) {
            runOneRound();

            OutputView.printRoundResult(this.cars);
        }
    }

    private void runOneRound() {
        for (Car car : cars) {
            car.advance();
        }
    }

    public List<Car> determineWinners() {
        int maxPosition = findMaxPosition();

        return findSamePositionCars(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = updateMaxPosition(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    private int updateMaxPosition(int maxPosition, int currentPosition) {
        if (currentPosition > maxPosition) {
            return currentPosition;
        }

        return maxPosition;
    }

    private List<Car> findSamePositionCars(int maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addSamePositionCars(winners, car, maxPosition);
        }

        return winners;
    }

    private void addSamePositionCars(List<Car> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}
