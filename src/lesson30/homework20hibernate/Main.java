package lesson30.homework20hibernate;

import lesson30.homework20hibernate.entity.Student;
import lesson30.homework20hibernate.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Student student = new Student("Alex","alex@gmail.com");
        service.addStudent(student);
        service.addStudent(new Student("Artem","artem@gmail.com"));
        service.addStudent(new Student("Vladimir","vladimir@gmail.com"));
        service.deleteStudent(3L);
        student.setName("Anna");
        student.setEmail("anna@gmail.com");
        service.updateStudent(student);
        System.out.println(service.getAllStudents());
        System.out.println(service.getStudent(2L));
    }
}
