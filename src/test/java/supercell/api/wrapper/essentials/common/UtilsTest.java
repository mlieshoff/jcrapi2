package supercell.api.wrapper.essentials.common;

import static org.assertj.core.api.Assertions.*;

import static supercell.api.wrapper.essentials.common.Utils.*;

import org.junit.jupiter.api.Test;

import java.util.Map;

class UtilsTest {

    private static final String EMPTY = "";
    private static final String KEY = "key";
    private static final String NOT_EMPTY = "not empty";

    @Test
    void isNotEmpty_whenEmptyMap_thenFalse() {

        boolean actual = isNotEmpty(Map.of());

        assertThat(actual).isFalse();
    }

    @Test
    void isNotEmpty_whenNonEmptyMap_thenTrue() {

        boolean actual = isNotEmpty(Map.of("key", "value"));

        assertThat(actual).isTrue();
    }

    @Test
    void isNotEmpty_whenNullMap_thenFalse() {

        boolean actual = isNotEmpty((Map<?, ?>) null);

        assertThat(actual).isFalse();
    }

    @Test
    void isNotEmpty_whenEmptyArray_thenFalse() {

        boolean actual = isNotEmpty(new String[] {});

        assertThat(actual).isFalse();
    }

    @Test
    void isNotEmpty_whenNonEmptyArray_thenTrue() {

        boolean actual = isNotEmpty(new String[] {"element"});

        assertThat(actual).isTrue();
    }

    @Test
    void isNotEmpty_whenNullArray_thenFalse() {

        boolean actual = isNotEmpty((Object[]) null);

        assertThat(actual).isFalse();
    }

    @Test
    void isBlank_whenEmptyString_thenTrue() {

        boolean actual = isBlank(EMPTY);

        assertThat(actual).isTrue();
    }

    @Test
    void isBlank_whenNullString_thenTrue() {

        boolean actual = isBlank(null);

        assertThat(actual).isTrue();
    }

    @Test
    void isBlank_whenNonEmptyString_thenFalse() {

        boolean actual = isBlank(NOT_EMPTY);

        assertThat(actual).isFalse();
    }

    @Test
    void isNotBlank_whenEmptyString_thenFalse() {

        boolean actual = isNotBlank(EMPTY);

        assertThat(actual).isFalse();
    }

    @Test
    void isNotBlank_whenNullString_thenFalse() {

        boolean actual = isNotBlank(null);

        assertThat(actual).isFalse();
    }

    @Test
    void isNotBlank_whenNonEmptyString_thenTrue() {

        boolean actual = isNotBlank(NOT_EMPTY);

        assertThat(actual).isTrue();
    }

    @Test
    void require_whenEmptyString_thenThrowsException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> require(KEY, EMPTY))
                .withMessage("key must be set! But was: ");
    }

    @Test
    void require_whenNonEmptyString_thenNoException() {

        assertThatNoException().isThrownBy(() -> require(KEY, NOT_EMPTY));
    }

    @Test
    void require_whenNullObject_thenThrowsException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> require(KEY, (Object) null))
                .withMessage("key must be set!");
    }

    @Test
    void require_whenNonNullObject_thenNoException() {

        assertThatNoException().isThrownBy(() -> require(KEY, new Object()));
    }
}
