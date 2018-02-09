package com.almundo.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Administrador
 */
public enum UserType {

  OPERADOR, SUPERVISOR, DIRECTOR;

  private static final List<UserType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static UserType getRandom() {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }

} // Fin clase $(name)
