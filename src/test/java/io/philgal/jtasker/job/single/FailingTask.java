package io.philgal.jtasker.job.single;

import io.philgal.jtasker.task.SimpleTask;

class FailingTask extends SimpleTask {
  public FailingTask() {
    super(() -> {
      throw new RuntimeException("Oh no, not again - (c) Major Tom");
    });
  }
}
