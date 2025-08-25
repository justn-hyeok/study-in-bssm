package org.example.student_management;

import org.example.student_management.application.course.CourseService;
import org.example.student_management.application.course.dto.CourseInfoDto;
import org.example.student_management.application.student.StudentService;
import org.example.student_management.application.student.dto.StudentInfoDto;
import org.example.student_management.repo.CourseRepository;
import org.example.student_management.repo.StudentRepository;
import org.example.student_management.ui.course.CourseController;
import org.example.student_management.ui.course.CoursePresenter;
import org.example.student_management.ui.student.StudentController;
import org.example.student_management.ui.student.StudentPresenter;
import org.example.student_management.ui.UserInputType;

public class Main {

  public static void main(String[] args) {
    StudentRepository studentRepository = new StudentRepository();
    CourseRepository courseRepository = new CourseRepository();

    StudentService studentService = new StudentService(studentRepository);
    CourseService courseService = new CourseService(courseRepository, studentService);

    CoursePresenter coursePresenter = new CoursePresenter();
    StudentPresenter studentPresenter = new StudentPresenter();

    CourseController courseController = new CourseController(coursePresenter, courseService, studentPresenter);
    StudentController studentController = new StudentController(studentPresenter, studentService);

    StudentInfoDto studentInfoDto =  new StudentInfoDto("pjh", 20, "seoul");
    StudentInfoDto studentInfoDto1 =  new StudentInfoDto("jwj", 21, "pusan");
    studentService.saveStudent(studentInfoDto);
    studentService.saveStudent(studentInfoDto1);

    CourseInfoDto courseInfoDto = new CourseInfoDto("바이올린",1000,"SATURDAY","pjh",10000L);
    CourseInfoDto courseInfoDto1 = new CourseInfoDto("첼로",1000,"MONDAY","jwj",10000L);
    courseService.registerCourse(courseInfoDto);
    courseService.registerCourse(courseInfoDto1);

    studentPresenter.showMenu();
    UserInputType userInputType = studentController.getUserInput();
    while (userInputType != UserInputType.EXIT) {
      switch (userInputType) {
        case NEW_STUDENT:
          studentController.registerStudent();
          break;
        case NEW_COURSE:
          courseController.registerCourse();
          break;
        case SHOW_COURSE_DAY_OF_WEEK:
          courseController.showCourseDayOfWeek();
          break;
        case ACTIVATE_STUDENT:
          studentController.activateStudent();
          break;
        case DEACTIVATE_STUDENT:
          studentController.deactivateStudent();
          break;
        case CHANGE_FEE:
          courseController.changeFee();
          break;
        default:
          studentPresenter.showErrorMessage();
          break;
      }
      studentPresenter.showMenu();
      userInputType = studentController.getUserInput();
    }
  }
}