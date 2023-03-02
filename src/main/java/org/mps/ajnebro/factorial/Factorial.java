package org.mps.ajnebro.factorial;

import java.math.BigInteger;

/**
 * Class providing methods to compute the factorial of an integer number
 *
 * @author Antonio J. Nebro
 */
public class Factorial {
  /**
   * Method using ints
   *
   * @param value
   * @return the factorial of value
   */
  public int compute(int value) {
    if (value < 0) {
      throw new NegativeValueException("The value " + value + " is negative");
    }
    if (value > 12) {
      throw new ParameterValueCausesOverflow("The value " + value + " is too high") ;
    }

    int result = 1;
    for (int i = 2; i <= value; i++) {
      result *= i;
    }
    return result;
  }

  /**
   * Method using class {@link BigInteger}
   *
   * @param value
   * @return the factorial of value
   */
  public BigInteger computeBigValue(int value) {
    if (value < 0) {
      throw new NegativeValueException("The value " + value + " is negative");
    }

    BigInteger result;
    result = BigInteger.ONE;
    for (int i = 2; i <= value; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }

    return result;
  }
}


