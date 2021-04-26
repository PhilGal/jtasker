package io.philgal.jtasker.task;

import io.philgal.jtasker.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTask extends AbstractTask {

  private final Runnable work;

  public SimpleTask(Runnable work) {
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
