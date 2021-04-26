package io.philgal.jtasker.task.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StateTest {

  @Test
  void testNewState() {
    State state = new NewState();
    assertThat(state.name()).isEqualTo("NEW");
    assertThat(state.isError()).isFalse();
    assertThat(state.isFinal()).isFalse();
  }

  @Test
  void testRunningState() {
    State state = new RunningState();
    assertThat(state.name()).isEqualTo("RUNNING");
    assertThat(state.isError()).isFalse();
    assertThat(state.isFinal()).isFalse();
  }

  @Test
  void testDoneState() {
    State state = new DoneState();
    assertThat(state.name()).isEqualTo("DONE");
    assertThat(state.isError()).isFalse();
    assertThat(state.isFinal()).isTrue();
  }

  @Test
  void testErrorState() {
    State state = new ErrorState();
    assertThat(state.name()).isEqualTo("ERROR");
    assertThat(state.isError()).isTrue();
    assertThat(state.isFinal()).isTrue();
  }

  @Test
  void testCancelledState() {
    State state = new CancelledState();
    assertThat(state.name()).isEqualTo("CANCELLED");
    assertThat(state.isError()).isFalse();
    assertThat(state.isFinal()).isTrue();
  }
}
