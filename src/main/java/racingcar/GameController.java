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
        }
    }

    private void runOneRound() {
        for (Car car : cars) {
            car.advance();
        }
    }
}
