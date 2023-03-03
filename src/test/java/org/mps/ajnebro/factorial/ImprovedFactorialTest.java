package org.mps.ajnebro.factorial;

/*
  Test cases
  1. factorial 0 -> 1
  2. factorial 1 -> 1
  3. factorial 2 -> 2
  4. factorial 3 -> 6
  5. factorial 5 -> 120
  6. factorial 12 -> 479001600
  7. factorial of a negative value -> raises an exception
  8. factorial of a big number -> raises an exception

  Extended cases when using BigInteger
  9. factorial of 13 ->  6227020800
  10. factorial of 18 -> 6402373705728000

  https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested
  https://github.com/fabriciorby/maven-surefire-junit5-tree-reporter
 */

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.condition.JRE.JAVA_21;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@DisplayName("Class Factorial ")
class ImprovedFactorialTest {
  Factorial factorial;

  @Test
  @DisplayName("is instantiated with new Factorial()")
  void isInstantiatedWithNew() {
    assertNotNull(new Factorial());
  }


  @BeforeEach
  void setup() {
    factorial = new Factorial();
  }

  @AfterEach
  void shutdown() {
    factorial = null;
  }

  @Nested
  @DisplayName("when the compute() method is called")
  class TestCasesForIntValues {
    @ParameterizedTest
    @DisplayName("valid results are obtained for values 0, 1, 2, 3, 4, 5, 12")
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "5, 120",
        "12, 479001600"
    })
    void theComputeMethodReturnsAValidResult(int number, int expectedValue) {
      int actualValue = factorial.compute(number);
      assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("an exception is raised if the value is negative or is higher than 12")
    void testThrownExceptions() {
      assertAll(
          "Test thrown exceptions",
          () -> assertThrows(NegativeValueException.class, () -> factorial.compute(-1)),
          () -> assertThrows(ParameterValueCausesOverflow.class, () -> factorial.compute(13)));
    }
  }

  @Nested
  @DisplayName("when the computeBigValue() method is called")
  @EnabledForJreRange(min = JAVA_8, max = JAVA_21)
  class TestCasesForBigIntegerResults {

    @Test
    @DisplayName("valid results are obtained for values 0, 1, 2, 3, 4, 5, 12")
    void computeBigValueMethodReturnsValidResults() {
      List<Integer> values = List.of(0, 1, 2, 3, 5, 12);
      List<BigInteger> expectedResults = Stream.of(1, 1, 2, 6, 120, 479001600).map(
          BigInteger::valueOf).collect(
          Collectors.toList());

      List<BigInteger> actualValues = values.stream().map(i -> factorial.computeBigValue(i))
          .collect(Collectors.toList());

      assertIterableEquals(expectedResults, actualValues);
    }

    @ParameterizedTest
    @DisplayName("valid results are obtained for values higher than 12")
    @CsvSource({
        "13, 6227020800.0",
        "18, 6402373705728000.0"
    })
    void computeBigValueReturnTheExceptedResult(int number, double expectedValue) {
      assertEquals(expectedValue, factorial.computeBigValue(number).doubleValue());
    }

    @Test
    @DisplayName("an exception is thrown if the value is negative")
    void factorialOfMinusOneRaisesAnException() {
      assertThrows(NegativeValueException.class, () -> factorial.computeBigValue(-1));
    }
  }
}