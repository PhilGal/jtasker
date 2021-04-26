package io.philgal.jtasker.job.single;

import io.philgal.jtasker.task.SimpleTask;

class DoNothingTask extends SimpleTask {
  public DoNothingTask() {
    super(() -> {
    });
  }
}
