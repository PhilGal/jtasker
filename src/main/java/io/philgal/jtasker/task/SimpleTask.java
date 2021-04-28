package io.philgal.jtasker.task;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class SimpleTask extends AbstractTask {

  private final Runnable work;

  public SimpleTask(Runnable work) {
    Objects.requireNonNull(work, "Work must be set");
    this.work = work;
  }

  @Override
  public void execute() {
    super.execute();
    try{
      work.run();
      super.complete();
    } catch (Exception e) {
      super.completeWithError(e);
    }
  }
}
