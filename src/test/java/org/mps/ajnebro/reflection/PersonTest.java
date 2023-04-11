package org.mps.ajnebro.reflection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mps.ajnebro.person.Person;
import org.springframework.test.util.ReflectionTestUtils;

class PersonTest {
  @Test
  void exampleOfReflectionAppliedToAConstructor() {
    String name = "Luis" ;
    int age = 23;
    String gender = "Male" ;

    var person = new Person(name, age, gender) ;

    assertEquals(name, ReflectionTestUtils.getField(person, "name")) ;
    assertEquals(age, ReflectionTestUtils.getField(person, "age")) ;
    assertEquals(gender, ReflectionTestUtils.getField(person, "gender")) ;
  }

  @Test
  void exampleOfReflectionAppliedToASetterMethod() {
    var person = new Person("María", 26, "Female") ;

    int newAge = 32 ;
    person.age(newAge) ;
    assertEquals(newAge, ReflectionTestUtils.getField(person, "age"));
  }

  @Test
  void exampleOfReflectionAppliedToAGetterMethod() {
    var person = new Person("María", 26, "Female") ;

    String newName = "Luisa" ;
    ReflectionTestUtils.setField(person, "name", newName);
    assertEquals(newName, person.name());
  }

  @Test
  void setAnInvalidAgeRaisesAnException() {
    assertThrows(RuntimeException.class, () -> new Person("María", -5, "Female") ) ;
  }

  @Test
  void exampleOfInvokingAPrivateMethod() {
    var person = new Person("María", 26, "Female") ;

    int validAge = 30 ;
    int checkedAge = ReflectionTestUtils.invokeMethod(person, "checkAge", validAge) ;

    assertEquals(validAge, checkedAge) ;
  }

  @Test
  void theFieldsOfAnInstanceHaveTheRightNames() {
    Object person = new Person("Luis", 23, "Male") ;
    Field[] fields = person.getClass().getDeclaredFields();

    List<String> actualFieldNames = Arrays.stream(fields).map(Field::getName).toList();

    assertTrue(List.of("age", "name", "gender").containsAll(actualFieldNames)) ;
  }
}
