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
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);
    return convertCoursesToDtos(courses);
  }

  private List<CourseInfoDto> convertCoursesToDtos(List<Course> courses) {
    List<CourseInfoDto> courseDtos = new ArrayList<>();
    for (Course course : courses) {
      courseDtos.add(new CourseInfoDto(course));
    }
    return courseDtos;
  }

  public void changeFee(String studentName, int fee) {
    List<Course> studentCourses = courseRepository.getCourseListByStudent(studentName);
    
    if (studentCourses.isEmpty()) {
      throw new IllegalArgumentException("해당 학생의 수업이 없습니다.");
    }
    
    List<Course> updatedCourses = updateCourseFees(studentCourses, fee);
    courseRepository.saveCourses(updatedCourses);
  }

  private List<Course> updateCourseFees(List<Course> courses, int baseFee) {
    List<Course> updatedCourses = new ArrayList<>();
    for (Course course : courses) {
      int finalFee = calculateFinalFee(baseFee, course.getDayOfWeek());
      Course updatedCourse = createUpdatedCourse(course, finalFee);
      updatedCourses.add(updatedCourse);
    }
    return updatedCourses;
  }

  private int calculateFinalFee(int baseFee, DayOfWeek dayOfWeek) {
    if (isWeekend(dayOfWeek)) {
      return (int) (baseFee * 1.5);
    }
    return baseFee;
  }

  private boolean isWeekend(DayOfWeek dayOfWeek) {
    return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
  }

  private Course createUpdatedCourse(Course originalCourse, int newFee) {
    Student student = studentService.getStudent(originalCourse.getStudentName());
    return new Course(
        student,
        originalCourse.getCourseName(),
        newFee,
        originalCourse.getDayOfWeek(),
        originalCourse.getCourseTime()
    );
  }
}
