package org.example.student_management.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.student_management.domain.Course;
import org.example.student_management.domain.DayOfWeek;

public class CourseRepository {

  private final Map<String, Course> courseMap = new HashMap<>();

  public void save(Course course) {
    courseMap.put(course.getCourseName(), course);
  }

  public List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseMap.values()) {
      if (course.isSameDay(dayOfWeek) && course.isActivateUser()) {
        courses.add(course);
      }
    }
    return courses;
  }

  public List<Course> getCourseListByStudent(String studentName) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseMap.values()) {
      if (course.getStudentName().equals(studentName)) {
        courses.add(course);
      }
    }
    return courses;
  }

  public void saveCourses(List<Course> courses) {
    for (Course course : courses) {
      courseMap.put(course.getCourseName(), course);
    }
  }
}
