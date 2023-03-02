package org.mps.ajnebro.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class MockingRandomNumberGenerators {
  @Test
  void mockingARandomGenerator() {
    // STEP 1: create mock object
    Random mockedRandom = mock(Random.class) ;

    // STEP 2: stubbing
    when(mockedRandom.nextDouble()).thenReturn(0.1) ;

    // STEP 3: using the mocked object
    double randomValue = mockedRandom.nextDouble() ;

    // STEP 4: asserting
    assertEquals(0.1, randomValue); ;

    // STEP 5: optional -> verifying
    verify(mockedRandom).nextDouble() ;
  }

  @Test
  void mockingARandomGeneratorReturningSeveralValues() {
    // STEP 1: create mock object
    Random mockedRandom = mock(Random.class) ;

    // STEP 2: stubbing
    when(mockedRandom.nextInt(10)).thenReturn(1, 2, 5) ;

    // STEP 3: using the mocked object
    int randomValue1 = mockedRandom.nextInt(10) ;
    int randomValue2 = mockedRandom.nextInt(10) ;
    int randomValue3 = mockedRandom.nextInt(10) ;

    // STEP 4: asserts
    assertEquals(1, randomValue1);
    assertEquals(2, randomValue2);
    assertEquals(5, randomValue3);

    // STEP 5: optional -> verifying
    verify(mockedRandom, times(3)).nextInt(10) ;
  }
}
