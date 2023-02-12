package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    @DisplayName("차 이름이 중복되면 예외가 발생한다")
    void createDuplicateCars() {
        //given
        Car car1 = new Car("car");
        Car car2 = new Car("car");

        //when
        //then
        assertThatThrownBy(() -> new RacingCars(List.of(car1, car2)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("차 이름이 중복되지 않는 경우")
    void createNonDuplicateCars() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        //when
        new RacingCars(List.of(car1, car2));
        //then
    }

    @Test
    @DisplayName("차 개수가 100개 초과인 경우 예외가 발생한다")
    void validateCarCountOverLimit() {
        //given
        int carLimit = 100;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i <= carLimit; i++) {
            cars.add(new Car(String.valueOf(i)));
        }

        //when
        //then
        assertThatThrownBy(() -> new RacingCars(cars))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(String.format(ErrorCode.TOO_MANY_CAR.getMessage(), carLimit));
    }
}