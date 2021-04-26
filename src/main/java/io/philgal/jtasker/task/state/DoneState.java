package io.philgal.jtasker.task.state;

public class DoneState implements State {

  @Override
  public String name() {
    return "DONE";
  }

  @Override
  public boolean isFinal() {
    return true;
  }
}
