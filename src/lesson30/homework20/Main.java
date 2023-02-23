package lesson30.homework20;

import lesson30.homework20.entity.Student;
import lesson30.homework20.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        service.addStudent(new Student(1L,"Alex","alex@gmail.com"));
        service.addStudent(new Student(2L,"Artem","artem@gmail.com"));
        service.addStudent(new Student(3L,"Vladimir","vladimir@gmail.com"));
        service.deleteStudent(3L);
        service.updateStudent(new Student(1L,"Anna","anna@gmail.com"));
        System.out.println(service.getAllStudents());
        System.out.println(service.getStudent(2L));
    }
}
