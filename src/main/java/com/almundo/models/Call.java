package com.almundo.models;

import com.almundo.exceptions.InvalidSizeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 *
 * @author Administrador
 */
public class Call {

  private UUID id;
  private int life;
  private LocalDateTime initHour;
  private LocalDateTime endHour;
  private User adviser;
  private User customer;

  public Call(int life, LocalDateTime initHour, LocalDateTime endHour, User adviser) {
    validateDuration(life);
    this.id = UUID.randomUUID();
    this.life = life;
    this.initHour = initHour;
    this.endHour = endHour;
    this.adviser = adviser;
  }

  public void validateDuration(int duration) {
    if (duration < Constants.CALL_MIN_DURATION || duration > Constants.CALL_MAX_DURATION) {
      new InvalidSizeException("La duración no esta entre los valores estimados, min: " + Constants.CALL_MIN_DURATION + " seg y max: " + Constants.CALL_MAX_DURATION + " seg");
    }

  }

  public LocalDateTime getInitHour() {
    return initHour;
  }

  public void setInitHour(LocalDateTime initHour) {
    this.initHour = initHour;
  }

  public LocalDateTime getEndHour() {
    return endHour;
  }

  public void setEndHour(LocalDateTime endHour) {
    this.endHour = endHour;
  }

  public User getAdviser() {
    return adviser;
  }

  public void setAdviser(User adviser) {
    this.adviser = adviser;
  }

  @Override
  public String toString() {
    return this.id + "      "
            + this.initHour.format(DateTimeFormatter.ISO_DATE)
            + "      "
            + (this.endHour == null ? "empty" : this.endHour.format(DateTimeFormatter.ISO_DATE))
            + "       " + "Atendida por: " + adviser.getDisplayName();
  }

} // Fin clase $(name)
