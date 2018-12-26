package jcrapi2.request;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BlankRequestTest extends RequestTestBase {

  @Test
  void getQueryParameters_whenAddParameter_thenThrowException() throws Exception {
    assertThrows(UnsupportedOperationException.class,
        () -> BlankRequest.builder().build().getQueryParameters().put("k", "v"));
  }

  @Test
  void getRestParameters_whenAddParameter_thenThrowException() throws Exception {
    assertThrows(UnsupportedOperationException.class,
        () -> BlankRequest.builder().build().getRestParameters().add("k"));
  }

  @Override
  Object getBuilder() {
    return new BlankRequest.BlankRequestBuilder<>();
  }

}