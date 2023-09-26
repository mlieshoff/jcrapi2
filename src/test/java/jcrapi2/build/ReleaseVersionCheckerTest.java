package jcrapi2.build;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReleaseVersionCheckerTest {

    @Test
    void main_whenWithNullArray_thenThrowException() {

        assertThrows(NullPointerException.class, () -> ReleaseVersionChecker.main(null));
    }

    @Test
    void main_whenWithEmptyArray_thenThrowException() {

        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> ReleaseVersionChecker.main(new String[] {}));
    }

    @Test
    void main_whenWithNullParameter_thenThrowException() {

        assertThrows(
                NullPointerException.class, () -> ReleaseVersionChecker.main(new String[] {null}));
    }

    @Test
    void main_whenWithEmptyParameter_thenThrowException() {

        assertThrows(
                IllegalStateException.class, () -> ReleaseVersionChecker.main(new String[] {""}));
    }

    @Test
    void main_whenWithEmptyParameter_thenThrowException2() {

        assertThrows(
                IllegalStateException.class,
                () ->
                        ReleaseVersionChecker.main(
                                new String[] {
                                    "./src/test/resources/version_different.txt", "./pom.xml"
                                }));
    }
}
