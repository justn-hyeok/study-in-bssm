package org.example.student_management.application.student.dto;

public class StudentInfoDto {
  private final String name;
  private final int age;
  private final String address;

  public StudentInfoDto(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }
}