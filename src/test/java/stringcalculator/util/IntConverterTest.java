package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IntConverterTest {

  @DisplayName("숫자가 아닌 문자는 Number로 convert할 수 없다.")
  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "/", "?"})
  public void convert_throwException_notNumber(String input) {
    assertThatThrownBy(() -> IntConverter.convert(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("숫자인 문자를 Number로 convert한다.")
  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "10", "100"})
  public void convert_Int(String input) {
    assertThat(IntConverter.convert(input))
        .isEqualTo(Integer.parseInt(input));
  }
}
