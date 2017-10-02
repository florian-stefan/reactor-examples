package de.mobile.reactor.introduction;

import de.mobile.reactor.something.Somethings;
import de.mobile.reactor.something.Something;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SomeClient01 {

  private final Somethings somethings;

  public Something loadById(int id) {
    return somethings.loadById(id);
  }

}
