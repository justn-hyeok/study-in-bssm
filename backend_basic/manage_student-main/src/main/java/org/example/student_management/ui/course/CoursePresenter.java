package org.example.student_management.ui.course;

import java.util.List;
import org.example.student_management.application.course.dto.CourseInfoDto;

public class CoursePresenter {

  public void showInputCourseName() {
    System.out.println("수강과목을 입력해주세요.");
  }

  public void showInputCourseFee() {
    System.out.println("수강료를 입력해주세요.");
  }

  public void showInputDayOfWeek() {
    System.out.println("수업 요일을 입력해주세요.");
  }

  public void showInputCourseTime() {
    System.out.println("수업 시간을 입력해주세요.");
  }

  public void showCourseList(List<CourseInfoDto> courseInfoDtoList) {
    System.out.println("수강 목록을 출력합니다.");

    if (courseInfoDtoList.isEmpty()) {
      System.out.println("수강 목록이 없습니다.");
      return;
    }

    for (CourseInfoDto courseInfoDto : courseInfoDtoList) {
      System.out.println(courseInfoDto.getCourseName());
      System.out.println(courseInfoDto.getStudentName());
      System.out.println(courseInfoDto.getFee());
      System.out.println(courseInfoDto.getCourseTime());
    }
  }

  public void showCourseRegistered() {
    System.out.println("수강이 등록되었습니다.");
  }

  public void showFeeChanged() {
    System.out.println("수강료가 변경되었습니다.");
  }

  public void showInvalidInputMessage() {
    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
  }
}
