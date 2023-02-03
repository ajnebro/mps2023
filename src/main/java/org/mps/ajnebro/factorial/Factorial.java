package org.mps.ajnebro.factorial ;

public class Factorial {
  public int compute(int value) {
    int result ;
    if ((value == 0) || (value == 1)) {
      result = 1 ;
    } else if (value == 2){
      result = 2 ;
    } else {
      return value * compute(value-1) ;
    }
    return result ;
  }
}
