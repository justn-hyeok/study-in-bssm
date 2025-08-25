package org.example.student_management.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.example.student_management.domain.Student;

public class StudentRepository {

  private final Map<String, Student> studentMap = new HashMap<>();

  public void save(Student student) {
    studentMap.put(student.getName(), student);
  }

  public Optional<Student> findByName(String name) {
    return Optional.ofNullable(studentMap.get(name));
  }
}
