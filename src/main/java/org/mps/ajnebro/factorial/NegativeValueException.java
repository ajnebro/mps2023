package org.mps.ajnebro.factorial;

/**
 * @author Antonio J. Nebro
 */
public class NegativeValueException extends RuntimeException {

  /**
   * Exception thrown when the value of the parameter of the {@link Factorial#compute} method is a
   * negative number
   *
   * @param errorMessage
   */
  public NegativeValueException(String errorMessage) {
    super(errorMessage);
  }
}
