package jcrapi2;

import static jcrapi2.Preconditions.checkNotBlank;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PreconditionsTest {

  private static final String KEY = "key";

  @Test
  void checkNotBlank_whenWithNull_throwException() {
    assertThrows(NullPointerException.class, () -> checkNotBlank(null, KEY));
  }

  @Test
  void checkNotBlank_whenWithEmpty_throwException() {
    assertThrows(IllegalArgumentException.class, () -> checkNotBlank(EMPTY, KEY));
  }

  @Test
  void checkNotBlank_whenWithValidParameters_doNothing() {
    checkNotBlank("value", KEY);
  }

}