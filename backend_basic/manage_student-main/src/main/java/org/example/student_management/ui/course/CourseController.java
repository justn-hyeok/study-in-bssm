package org.example.student_management.ui.course;

import java.util.List;
import java.util.Scanner;
import org.example.student_management.application.course.CourseService;
import org.example.student_management.application.course.dto.CourseInfoDto;
import org.example.student_management.domain.DayOfWeek;
import org.example.student_management.ui.student.StudentPresenter;

public class CourseController {

  private final CoursePresenter coursePresenter;
  private final CourseService courseService;
  private final StudentPresenter studentPresenter;
  private final Scanner scanner = new Scanner(System.in);

  public CourseController(CoursePresenter coursePresenter, CourseService courseService, StudentPresenter studentPresenter) {
    this.coursePresenter = coursePresenter;
    this.courseService = courseService;
    this.studentPresenter = studentPresenter;
  }

  public void registerCourse() {
    String studentName = getStudentName();
    String courseName = getCourseName();
    int fee = getCourseFee();
    DayOfWeek dayOfWeek = getDayOfWeek();
    Long courseTime = getCourseTime();

    CourseInfoDto courseInfoDto = new CourseInfoDto(courseName, fee, dayOfWeek.name(), studentName, courseTime);
    courseService.registerCourse(courseInfoDto);

    coursePresenter.showCourseRegistered();
  }

  public void showCourseDayOfWeek() {
    DayOfWeek dayOfWeek = getDayOfWeek();

    List<CourseInfoDto> result = courseService.getCourseDayOfWeek(dayOfWeek);

    coursePresenter.showCourseList(result);
  }

  public void changeFee() {
    String studentName = getStudentName();
    int fee = getCourseFee();

    courseService.changeFee(studentName, fee);

    coursePresenter.showFeeChanged();
  }

  private String getStudentName() {
    studentPresenter.showInputStudentName();
    return scanner.nextLine();
  }

  private String getCourseName() {
    coursePresenter.showInputCourseName();
    return scanner.nextLine();
  }

  private int getCourseFee() {
    while (true) {
      coursePresenter.showInputCourseFee();
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        coursePresenter.showInvalidInputMessage();
      }
    }
  }

  private DayOfWeek getDayOfWeek() {
    while (true) {
      coursePresenter.showInputDayOfWeek();
      try {
        return DayOfWeek.valueOf(scanner.nextLine().toUpperCase());
      } catch (IllegalArgumentException e) {
        coursePresenter.showInvalidInputMessage();
      }
    }
  }

  private Long getCourseTime() {
    while (true) {
      coursePresenter.showInputCourseTime();
      try {
        return Long.parseLong(scanner.nextLine());
      } catch (NumberFormatException e) {
        coursePresenter.showInvalidInputMessage();
      }
    }
  }
}
