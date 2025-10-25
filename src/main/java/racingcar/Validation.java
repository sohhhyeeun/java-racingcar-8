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

    public static void validateAttemptCount(String attemptCountStr) {
        validateIsNumeric(attemptCountStr);
        validateIsPositive(attemptCountStr);
    }

    private static void validateIsNumeric(String attemptCountStr) {
        try {
            Integer.parseInt(attemptCountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로만 입력해 주세요.");
        }
    }

    private static void validateIsPositive(String attemptCountStr) {
        int attemptCount = Integer.parseInt(attemptCountStr);

        if (attemptCount < 1) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수만 가능합니다.");
        }
    }
}
