package io.philgal.jtasker.task.state;

public interface State {

  String name();

  default boolean isError() {
    return false;
  }

  default boolean isFinal() {
    return false;
  }
}
