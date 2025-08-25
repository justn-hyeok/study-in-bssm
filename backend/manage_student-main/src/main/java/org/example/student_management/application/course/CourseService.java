package org.example.student_management.application.course;

import java.util.ArrayList;
import java.util.List;
import org.example.student_management.application.course.dto.CourseInfoDto;
import org.example.student_management.application.student.StudentService;
import org.example.student_management.domain.Course;
import org.example.student_management.domain.DayOfWeek;
import org.example.student_management.domain.Student;
import org.example.student_management.repo.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // 과제 구현 부분
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);

    return new ArrayList<>();
  }

  public void changeFee(String studentName, int fee) {
    // 과제 구현 부분

  }
}
