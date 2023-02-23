package lesson30.homework20.dao;

import lesson30.homework20.entity.Student;

import java.util.List;

public interface DAO {

    void addStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
}
