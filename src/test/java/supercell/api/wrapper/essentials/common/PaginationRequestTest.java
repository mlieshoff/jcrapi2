package supercell.api.wrapper.essentials.common;

import static org.assertj.core.api.Assertions.*;

import static supercell.api.wrapper.essentials.common.PaginationRequest.*;

import org.junit.jupiter.api.Test;

import java.util.Map;

class PaginationRequestTest {

    private static final String CURSOR_AFTER = "cursorAfter";
    private static final String CURSOR_BEFORE = "cursorBefore";
    private static final String EMPTY = "";
    private static final String POSITIVE_LIMIT_AS_STRING = "10";

    private static final int POSITIVE_LIMIT = 10;
    private static final int ZERO_LIMIT = 0;

    @Test
    void getQueryParameters_whenLimitIsZero_thenLimitNotInMap() {
        PaginationRequest request = new PaginationRequest(ZERO_LIMIT, null, null, false);

        Map<String, Object> actual = request.getQueryParameters();

        assertThat(actual).doesNotContainKey(QUERY_PARAM_LIMIT);
    }

    @Test
    void getQueryParameters_whenLimitIsPositive_thenLimitInMap() {
        PaginationRequest request = new PaginationRequest(POSITIVE_LIMIT, null, null, false);

        Map<String, Object> actual = request.getQueryParameters();

        assertThat(actual).containsEntry(QUERY_PARAM_LIMIT, POSITIVE_LIMIT_AS_STRING);
    }

    @Test
    void getQueryParameters_whenAfterIsNotBlank_thenAfterInMap() {
        PaginationRequest request = new PaginationRequest(ZERO_LIMIT, CURSOR_AFTER, null, false);

        Map<String, Object> actual = request.getQueryParameters();

        assertThat(actual).containsEntry(QUERY_PARAM_AFTER, CURSOR_AFTER);
    }

    @Test
    void getQueryParameters_whenAfterIsBlank_thenAfterNotInMap() {
        PaginationRequest request = new PaginationRequest(ZERO_LIMIT, EMPTY, null, false);

        Map<String, Object> actual = request.getQueryParameters();

        assertThat(actual).doesNotContainKey(QUERY_PARAM_AFTER);
    }

    @Test
    void getQueryParameters_whenBeforeIsNotBlank_thenBeforeInMap() {
        PaginationRequest request = new PaginationRequest(ZERO_LIMIT, null, CURSOR_BEFORE, false);

        Map<String, Object> actual = request.getQueryParameters();

        assertThat(actual).containsEntry(QUERY_PARAM_BEFORE, CURSOR_BEFORE);
    }

    @Test
    void getQueryParameters_whenBeforeIsBlank_thenBeforeNotInMap() {
        PaginationRequest request = new PaginationRequest(ZERO_LIMIT, null, EMPTY, false);

        Map<String, Object> queryParams = request.getQueryParameters();

        assertThat(queryParams).doesNotContainKey(QUERY_PARAM_BEFORE);
    }

    @Test
    void getQueryParameters_whenAllParametersProvided_thenAllParametersInMap() {
        PaginationRequest request =
                new PaginationRequest(POSITIVE_LIMIT, CURSOR_AFTER, CURSOR_BEFORE, false);

        Map<String, Object> actual = request.getQueryParameters();

        assertThat(actual)
                .containsEntry(QUERY_PARAM_LIMIT, POSITIVE_LIMIT_AS_STRING)
                .containsEntry(QUERY_PARAM_AFTER, CURSOR_AFTER)
                .containsEntry(QUERY_PARAM_BEFORE, CURSOR_BEFORE);
    }

    @Test
    void isStoreRawResponse_whenCalled_thenReturnValue() {
        PaginationRequest request = new PaginationRequest(ZERO_LIMIT, null, null, true);

        boolean actual = request.isStoreRawResponse();

        assertThat(actual).isTrue();
    }
}
