package org.mps.ajnebro.factorial ;

public class Factorial {
  public int compute(int value) {
    int result ;
    if (value < 0) {
      throw new NegativeValueException("The value " + value + " is negative");
    } else if (value == 0) {
      result = 1 ;
    } else {
      return value * compute(value-1) ;
    }
    return result ;
  }
}
