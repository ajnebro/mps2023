package org.mps.ajnebro.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

  @Test
  void examplesOfSpying() {
    List<String> list = new ArrayList<>();
    List<String> spyList = Mockito.spy(list);

    spyList.add("green");
    spyList.add("red");

    verify(spyList).add("green");
    verify(spyList).add("red");
    verify(spyList, times(2)).add(anyString());

    assertEquals(2, spyList.size());

    Mockito.when(spyList.size()).thenReturn(100);

    assertEquals(100, spyList.size());
  }


  private class Person {
    public String name ;
    public int age ;
  }

  @Test
  void exampleOfDummy() {
    List<Person> list = new ArrayList<>() ;
    Person dummy = new Person() ;
    list.add(dummy) ;

    assertEquals(1, list.size());
  }

  private class MyList<T> implements List<T> {

    @Override
    public int size() {
      return 0;
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public boolean contains(Object o) {
      return false;
    }

    @Override
    public Iterator<T> iterator() {
      return null;
    }

    @Override
    public Object[] toArray() {
      return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
      return null;
    }

    @Override
    public boolean add(T t) {
      return false;
    }

    @Override
    public boolean remove(Object o) {
      return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
      return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
      return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
      return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
      return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
      return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public T get(int index) {
      return null;
    }

    @Override
    public T set(int index, T element) {
      return null;
    }

    @Override
    public void add(int index, T element) {
    }

    @Override
    public T remove(int index) {
      return null;
    }

    @Override
    public int indexOf(Object o) {
      return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
      return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
      return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
      return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
      return null;
    }
  }

  @Test
  void exampleOfFake() {
    List<String> list = new MyList<>() ;

    assertTrue(list.isEmpty()) ;
  }
}
