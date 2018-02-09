package com.almundo.exceptions;

/**
 *
 * @author Administrador
 */
public class InvalidSizeException extends Exception{

  public InvalidSizeException() {
  }

  public InvalidSizeException(String message) {
    super(message);
  }

  public InvalidSizeException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidSizeException(Throwable cause) {
    super(cause);
  }

  public InvalidSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

} // Fin clase $(name)
