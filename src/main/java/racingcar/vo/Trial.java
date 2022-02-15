package racingcar.vo;

import java.util.Objects;

public class Trial {
    private static final int MINIMUM = 1;

    private int count;

    public Trial(int count) {
        validateRange(count);
        this.count = count;
    }

    private void validateRange(int count) {
        if (count < MINIMUM) {
            throw new IllegalArgumentException("시도 횟수는 1 이상을 입력해주세요.");
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Trial)) {
            return false;
        }
        Trial trial = (Trial)o;
        return count == trial.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public static Trial create(int count) {
        return new Trial(count);
    }
}