package de.mobile.reactor.shapes;

import lombok.Value;

@Value(staticConstructor = "of")
public class Square {
  private Color color;
}
