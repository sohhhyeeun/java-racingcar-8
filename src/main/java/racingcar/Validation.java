package racingcar;

public class Validation {
    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateLength(carName);
            validateBlank(carName);
        }

    }

    private static void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
    }
}
