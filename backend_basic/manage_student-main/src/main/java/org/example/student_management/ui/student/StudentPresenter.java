package org.example.student_management.ui.student;

public class StudentPresenter {

  public void showMenu() {
    System.out.println("1. 학생 추가");
    System.out.println("2. 수업 등록");
    System.out.println("3. 요일별 수업 조회");
    System.out.println("4. 학생 활성화");
    System.out.println("5. 학생 비활성화");
    System.out.println("6. 수강료 변경");
    System.out.println("0. 종료");
  }

  public void showStudentActivated() {
    System.out.println("학생이 활성화 되었습니다.");
  }

  public void showStudentDeactivated() {
    System.out.println("학생이 비활성화 되었습니다.");
  }

  public void showFeeChanged() {
    System.out.println("수강료가 변경되었습니다.");
  }

  public void showExit() {
    System.out.println("프로그램을 종료합니다.");
  }

  public void showInputStudentName() {
    System.out.println("학생 이름을 입력해주세요.");
  }

  public void showInputStudentAge() {
    System.out.println("학생 나이를 입력해주세요.");
  }

  public void showInputStudentAddress() {
    System.out.println("학생 주소를 입력해주세요.");
  }

  public void showErrorMessage() {
    System.out.println("해당하는 기능이 없습니다.");
  }

  public void showStudentRegistered() {
    System.out.println("학생이 등록되었습니다.");
  }

  public void showInvalidInputMessage() {
    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
  }
}
