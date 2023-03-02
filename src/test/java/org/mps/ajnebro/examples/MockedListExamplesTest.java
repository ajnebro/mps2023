package org.mps.ajnebro.examples;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockedListExamplesTest {

  @Test
  void someMockingExamples() {
    // Step 1. Create the mock object
    List<String> mockedList = Mockito.mock(List.class) ;

    // Step 2. Use the mock object
    mockedList.add("blue") ;
    mockedList.add("while") ;
    mockedList.add("red") ;
    mockedList.add("blue") ;

    //int size = mockedList.size() ;

    // Step 3. Verify
    Mockito.verify(mockedList, Mockito.times(2)).add("blue") ;
    Mockito.verify(mockedList, Mockito.never()).add("yellow") ;
    Mockito.verify(mockedList, Mockito.times(4)).add(Mockito.anyString()) ;
    Mockito.verify(mockedList, Mockito.atLeastOnce()).add("blue") ;
    Mockito.verify(mockedList, Mockito.never()).size() ;
  }

  @Test
  void someStubbingExamples() {
    // Step 1. Create the mock object
    List<String> mockedList = Mockito.mock(List.class) ;

    // Step 2. Use the mock object
    mockedList.add("blue") ;
    mockedList.add("while") ;
    mockedList.add("red") ;
    mockedList.add("blue") ;

    int currentListSize = 4 ;
    Mockito.when(mockedList.size()).thenReturn(currentListSize) ;

    int actualListSize = mockedList.size() ;
    assertEquals(currentListSize, actualListSize) ;
  }
}
