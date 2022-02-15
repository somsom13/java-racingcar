package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("정상적인 차 이름들을 받았을 경우")
    void validateNames() {
        RacingGame racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"));
        List<String> names = new ArrayList<>();

        for (Car car : racingGame.getCars()) {
            names.add(car.getName());
        }

        assertThat(names).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("빈 배열을 차 이름들로 받았을 경우")
    void validateNamesEmpty() {
        assertThatThrownBy(() -> {
            new RacingGame(Arrays.asList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("챔피언이 한명인 경우 챔피언 이름 받기")
    void getChampionNamesOnlyOneChampion() {
        RacingGame racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"));

        racingGame.getCars().get(0).move(5);
        racingGame.getCars().get(1).move(1);
        racingGame.getCars().get(2).move(3);

        assertThat(racingGame.getChampionNames())
            .contains("car1")
            .doesNotContain("car2")
            .doesNotContain("car3");
    }

    @Test
    @DisplayName("챔피언이 여러명인 경우 챔피언 이름 받기")
    void getChampionNames() {
        RacingGame racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"));

        racingGame.getCars().get(0).move(5);
        racingGame.getCars().get(1).move(5);
        racingGame.getCars().get(2).move(3);

        assertThat(racingGame.getChampionNames())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }
}