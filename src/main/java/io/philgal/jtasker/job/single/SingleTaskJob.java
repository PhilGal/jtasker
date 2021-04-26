package io.philgal.jtasker.job.single;

import io.philgal.jtasker.Job;
import io.philgal.jtasker.Task;
import io.philgal.jtasker.task.AbstractTask;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
public class SingleTaskJob implements Job {

  private String name = "Default job @" + LocalDateTime.now();

  private final Task task;

  public SingleTaskJob(Task task) {
    Objects.requireNonNull(task, "Task must be set");
    this.task = task;
  }

  public SingleTaskJob(Runnable task){
    Objects.requireNonNull(task, "Task must be set");
    this.task = new AbstractTask() {
      @Override
      public void execute() {
        super.execute();
        task.run();
        super.complete();
      }
    };
  }

  public SingleTaskJob(String name, Runnable task) {
    this(task);
    this.name = name;
  }

  public SingleTaskJob(String name, Task task) {
    this(task);
    this.name = name;
  }

  @Override
  public void execute() {
    log.info("Job \"{}\" is executing", name);
    task.execute();
  }

  @Override
  public boolean completed() {
    return task.completed();
  }

  public Task task() {
    return task;
  }
}
