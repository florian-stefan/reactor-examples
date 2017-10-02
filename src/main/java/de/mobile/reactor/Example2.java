package de.mobile.reactor;

import de.mobile.reactor.shapes.Circle;
import de.mobile.reactor.shapes.Square;
import reactor.core.publisher.Flux;

import static de.mobile.reactor.shapes.Color.*;

public class Example2 {

  public static void main(String[] args) {
    Circle[] circles = {Circle.of(BLUE), Circle.of(YELLOW), Circle.of(GREEN)};

    Flux.fromArray(circles)
      .map(Circle::getColor)
      .log()
      .map(Square::of)
      .log()
      .subscribe();
  }

}
