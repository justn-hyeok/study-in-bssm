package org.example.student_management.ui;

public enum UserInputType {
  NEW_STUDENT(1),
  NEW_COURSE(2),
  SHOW_COURSE_DAY_OF_WEEK(3),
  ACTIVATE_STUDENT(4),
  DEACTIVATE_STUDENT(5),
  CHANGE_FEE(6),
  EXIT(0);

  private final int userInput;

  UserInputType(int userInput) {
    this.userInput = userInput;
  }

  public static UserInputType of(int userInput) {
    for (UserInputType userInputType : values()) {
      if (userInputType.userInput == userInput) {
        return userInputType;
      }
    }
    throw new IllegalArgumentException("해당하는 기능이 없습니다.");
  }
}
