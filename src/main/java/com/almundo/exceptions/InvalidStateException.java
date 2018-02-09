package com.almundo.exceptions;

/**
 *
 * @author Administrador
 */
public class InvalidStateException extends Exception{

  public InvalidStateException() {
  }

  public InvalidStateException(String message) {
    super(message);
  }

  public InvalidStateException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidStateException(Throwable cause) {
    super(cause);
  }

  public InvalidStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

} // Fin clase $(name)
