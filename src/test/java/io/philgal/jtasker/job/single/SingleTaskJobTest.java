package io.philgal.jtasker.job.single;

import io.philgal.jtasker.Task;
import io.philgal.jtasker.task.AbstractTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SingleTaskJobTest {

  @Test
  @DisplayName("Execute single task job with a successful task")
  void shouldExecuteJob_SuccessfulTask() {

    AbstractTask task = new DoNothingTask();
    SingleTaskJob job = new SingleTaskJob("Simple task job", task);

    assertInitialConditions(task, job);

    job.execute();

    assertThat(task.error()).isEmpty();
    assertThat(task.failed()).isFalse();
    assertThat(task.completed()).isTrue();
    assertThat(job.completed()).isTrue();
  }

  @Test
  @DisplayName("Execute single task job with a successful lambda task")
  void shouldExecuteJob_SuccessfulLambdaTask() {

    SingleTaskJob job = new SingleTaskJob("Simple lambda job", () -> {});
    AbstractTask task = (AbstractTask) job.task();

    assertInitialConditions(task, job);

    job.execute();

    assertThat(task.error()).isEmpty();
    assertThat(task.failed()).isFalse();
    assertThat(task.completed()).isTrue();
    assertThat(job.completed()).isTrue();
  }

  @Test
  @DisplayName("Execute single task job with a failing task")
  void shouldExecuteJob_FailingTask() {

    AbstractTask task = new FailingTask();
    SingleTaskJob job = new SingleTaskJob(task);

    assertInitialConditions(task, job);

    job.execute();

    assertThat(task.error()).isPresent();
    assertThat(task.failed()).isTrue();
    assertThat(task.completed()).isTrue();
    assertThat(job.completed()).isTrue();
  }

  @Test
  @DisplayName("Cannot create a job without a task")
  void shouldThrowNullPointerException_TaskIsNull() {
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> new SingleTaskJob((Task) null));
    assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> new SingleTaskJob((Runnable) null));
  }

  //TODO: add long-running tasks

  private void assertInitialConditions(AbstractTask task, SingleTaskJob job) {
    assertThat(task.error()).isEmpty();
    assertThat(task.failed()).isFalse();
    assertThat(task.completed()).isFalse();
    assertThat(job.completed()).isFalse();
  }

}
