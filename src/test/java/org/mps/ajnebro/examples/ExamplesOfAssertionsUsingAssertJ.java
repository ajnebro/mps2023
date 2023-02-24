package org.mps.ajnebro.examples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.* ;


public class ExamplesOfAssertionsUsingAssertJ {
  @Test
  void examplesOfAssertions() {
    assertThat(4.0).isEqualTo(3.0 + 1.0);
    assertThat(4).isNotEqualTo(5 + 2);
    assertThat(6).isGreaterThan(5);

    assertThat("hello")
            .startsWith("h")
            .endsWith("o")
            .contains("e")
            .doesNotContain("n")
            .hasSize(5);

    double[] expectedArray = new double[]{1.0, 5.0, 5.2};
    assertThat(expectedArray).isEqualTo(new double[]{1.0, 5.0, 5.2});
    assertThat(expectedArray)
            .contains(5.0)
            .containsAnyOf(1.0, 2.0);

    double[] anotherArray = expectedArray;
    assertThat(expectedArray).isSameAs(anotherArray);

    Object nullObject = null;
    assertThat(nullObject).isNull();
  }
}
