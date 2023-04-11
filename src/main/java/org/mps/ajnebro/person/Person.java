package org.mps.ajnebro.person;

import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Antonio J. Nebro
 */
public class Person {

  private String name;
  private int age;
  private String gender; // Male, Female

  /**
   * Constructs a person with a name, age and gender.
   *
   * @param name   the name of the person
   * @param age    the age of the person
   * @param gender the gender of the person
   */
  public Person(String name, int age, String gender) {
    this.name = name;
    this.age = checkAge(age);
    this.gender = gender;
  }

  private int checkAge(int age) {
    if ((age < 0) || (age > 150)) {
      throw new RuntimeException("Invalid age: " + age) ;
    }

    return age ;
  }

  public String name() {
    return name;
  }

  public void name(String newName) {
    this.name = newName;
  }

  public int age() {
    return age;
  }

  public void age(int newAge) {
    this.age = checkAge(newAge);
  }

  public String gender() {
    return gender;
  }

  public void gender(String newGender) {
    gender = newGender ;
  }
}
