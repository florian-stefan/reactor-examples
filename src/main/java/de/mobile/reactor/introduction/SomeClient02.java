package de.mobile.reactor.introduction;

import de.mobile.reactor.something.Somethings;
import de.mobile.reactor.something.Something;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RequiredArgsConstructor
public class SomeClient02 {

  private final Somethings somethings;
  private final Executor executor;

  public CompletableFuture<Something> loadById(int id) {
    return supplyAsync(() -> somethings.loadById(id), executor);
  }

}
