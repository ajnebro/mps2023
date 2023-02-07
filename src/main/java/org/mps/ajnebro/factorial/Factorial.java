package org.mps.ajnebro.factorial;

import java.math.BigInteger;

/**
 * Class providing methods to compute the factorial of an integer number
 *
 * @author Antonio J. Nebro
 */
public class Factorial {
  public int compute(int value) {
    if (value < 0) {
      throw new NegativeValueException("The value " + value + " is negative");
    }
    int result = 1;
    for (int i = 2; i <= value; i++) {
      result *= i;
    }
    return result;
  }

  public BigInteger computeBigValue(int value) {
    if (value < 0) {
      throw new NegativeValueException("The value " + value + " is negative");
    }

    BigInteger result;
    result = BigInteger.ONE;
    for (int i = 2; i <= value; i++) {
      result = result.multiply(BigInteger.valueOf(value));
    }

    return result;
  }
}


