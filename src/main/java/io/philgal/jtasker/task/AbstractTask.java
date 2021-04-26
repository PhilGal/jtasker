package io.philgal.jtasker.task;

import io.philgal.jtasker.Task;
import io.philgal.jtasker.task.state.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public abstract class AbstractTask implements Task {

  protected State state = new NewState();
  private Throwable error;

  @Override
  public void execute() {
    log.info("Executing a task");
    state = new RunningState();
  }

  @Override
  public boolean completed() {
    return state.isFinal();
  }

  @Override
  public boolean failed() {
    return error != null || state.isError();
  }

  @Override
  public Optional<Throwable> error() {
    return Optional.ofNullable(error);
  }

  protected void complete() {
    state = new DoneState();
    log.info("Task completed!");
  }

  protected void completeWithError(Throwable e) {
    log.warn("Task terminated with error", e);
    error = e;
    state = new ErrorState();
  }
}
