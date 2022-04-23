package jcrapi2;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Preconditions {

  public static void checkNotBlank(String s, String key) {
    checkNotNull(s, key);
    checkArgument(!s.isEmpty(), key);
  }

}
