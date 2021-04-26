package io.philgal.jtasker;

import java.util.Optional;

public interface Task {

  void execute();

  boolean completed();

  default boolean failed() {
    return false;
  }

  default Optional<Throwable> error() {
    return Optional.empty();
  }
}
