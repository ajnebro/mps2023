package org.mps.ajnebro.factorial;

/*
  Test cases
  1. factorial 0 -> 1
  2. factorial 1 -> 1
  3. foctorial 2 -> 2
  4. factorial 3 -> 6
  5. factorial 5 -> 120
  6. factorial of a negative value -> ??
  7. factorial of a bit number -> ??
 */

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_21;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

class ImprovedFactorialTest {
  Factorial factorial;

  @BeforeEach
  void setup() {
    factorial = new Factorial();
  }

  @AfterEach
  void shutdown() {
    factorial = null;
  }

  /*
  @ParameterizedTest
  @ValueSource(ints= { 20, 100, Integer.MAX_VALUE, 1000000 })
 public void should_throw_exception_factorial_of_values_that_overflows(int candidate) {
    Assertions.assertThrows(RuntimeException.class, ()-> factorial.compute(candidate));

}
   */


  @ParameterizedTest
  @DisplayName("Factorial del método computeBigInteger para valores básicos positivos es correcto")
  @CsvSource({
          "0, 1",
          "1, 1",
          "2, 2",
          "3, 6",
          "5, 120"
  })
  void bigIntegerFactorialIsCorrect(int number, BigInteger expectedValue) {
    BigInteger obtainedValue = factorial.computeBigValue(number);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  @EnabledForJreRange(min = JAVA_8, max = JAVA_21)
  /*
  @EnabledOnOs(OS.WINDOWS)
  @EnabledOnOs({OS.MAC,OS.LINUX})
  @DisabledOnOs(OS.WINDOWS)
  */
  void factorialOf13IsTooLarge() {
    assertThrows(RuntimeException.class, ()->factorial.compute(13));
  }


  @Test
  void factorialOf7Is5040OnBothImplementations() {
    int expectedValue = 5040;
    assertAll(() -> {
      int actualValue = factorial.compute(7);
      assertEquals(expectedValue,actualValue);
    }, () -> {
      BigInteger actualValue = factorial.computeBigValue(7);
      assertEquals(BigInteger.valueOf(expectedValue),actualValue);
    });
  }

  @Test
  void factorialOf6_7_8_9Returns720_5040_40320_362880(){
    Iterable<Integer> expectedValues = new ArrayList<>(asList(720, 5040, 40320, 362880));
    Iterable<Integer> obtainedValues = new LinkedList<>(asList(factorial.compute(6), factorial.compute(7), factorial.compute(8), factorial.compute(9)));
    assertIterableEquals(expectedValues, obtainedValues);
  }


  @Test
  void factorialOfZeroIsOne() {
    int obtainedValue = factorial.compute(0);
    int expectedValue = 1;

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  void factorialOfOneIsOne() {
    int obtainedValue = factorial.compute(1);
    int expectedValue = 1;

    assertEquals(expectedValue, obtainedValue);
  }

  void factorialOfTwoIsTwo() {
    int obtainedValue = factorial.compute(2);
    int expectedValue = 2;

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  void factorialOf3Is6() {
    int obtainedValue = factorial.compute(3);
    int expectedValue = 6;

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  void factorialOf5Is120() {
    int obtainedValue = factorial.compute(5);
    int expectedValue = 120;

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  void factorialOfMinusOneIs() {
    assertThrows(NegativeValueException.class, () -> factorial.compute(-1));
  }
}