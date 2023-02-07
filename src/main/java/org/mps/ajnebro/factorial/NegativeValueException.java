package org.mps.ajnebro.factorial;

public class NegativeValueException extends RuntimeException{
  public NegativeValueException(String errorMessage) {
    super(errorMessage) ;
  }
}
