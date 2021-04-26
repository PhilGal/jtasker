package io.philgal.jtasker.task.state;

public class CancelledState implements State {

  @Override
  public String name() {
    return "CANCELLED";
  }

  @Override
  public boolean isFinal() {
    return true;
  }
}
