package de.mobile.reactor.introduction;

import de.mobile.reactor.something.Somethings;
import de.mobile.reactor.something.Something;
import de.mobile.reactor.something.SomethingsImpl.SomethingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SomeClient03Test {

  private SomeClient03 sut;

  @Test
  public void shouldLoadSomething() throws Exception {
    givenSomethingClientFor(new Something(1, "something"));

    CompletableFuture<Something> eventualSomething = sut.loadById(1);

    assertThat(eventualSomething.get()).isEqualTo(new Something(1, "something"));
  }

  @Test
  public void shouldFailToLoadSomething() throws Exception {
    givenSomethingClientFor(new SomethingNotFoundException(1));

    CompletableFuture<Something> eventualSomething = sut.loadById(1);

    assertThatThrownBy(eventualSomething::get).hasCause(new SomethingNotFoundException(1));
  }

  private void givenSomethingClientFor(Exception error) {
    sut = new SomeClient03(new SomethingsStub(callback -> callback.accept(error, null)));
  }

  private void givenSomethingClientFor(Something something) {
    sut = new SomeClient03(new SomethingsStub(callback -> callback.accept(null, something)));
  }

  @RequiredArgsConstructor
  private static class SomethingsStub implements Somethings {

    private final Consumer<BiConsumer<Exception, Something>> callbackHandler;

    @Override
    public Something loadById(int id) {
      throw new NotImplementedException();
    }

    @Override
    public void loadById(int id, BiConsumer<Exception, Something> callback) {
      callbackHandler.accept(callback);
    }

  }

}
