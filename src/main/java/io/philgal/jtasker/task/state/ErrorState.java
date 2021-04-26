package io.philgal.jtasker.task.state;

public class ErrorState implements State {

  @Override
  public String name() {
    return "ERROR";
  }

  @Override
  public boolean isError() {
    return true;
  }

  @Override
  public boolean isFinal() {
    return true;
  }
}
