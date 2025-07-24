package com.demo.springboot.service.impl;

import com.demo.springboot.entity.Student;
import com.demo.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final List<Student> students;

    public StudentServiceImpl() {
        this.students = new ArrayList<>();
        this.students.add(new Student(1L, "John", "Doe", "john.doe@example.com", "123456789"));
        this.students.add(new Student(2L, "Jane", "Smith", "jane.smith@example.com", "987654321"));
        this.students.add(new Student(3L, "Alice", "Johnson", "alice.johnson@example.com", "111222333"));
        this.students.add(new Student(4L, "Bob", "Williams", "bob.williams@example.com", "444555666"));
        this.students.add(new Student(5L, "Emma", "Brown", "emma.brown@example.com", "777888999"));
        this.students.add(new Student(6L, "Liam", "Davis", "liam.davis@example.com", "000111222"));
        this.students.add(new Student(7L, "Olivia", "Miller", "olivia.miller@example.com", "333444555"));
        this.students.add(new Student(8L, "Noah", "Wilson", "noah.wilson@example.com", "666777888"));
        this.students.add(new Student(9L, "Ava", "Moore", "ava.moore@example.com", "999000111"));
        this.students.add(new Student(10L, "Elijah", "Taylor", "elijah.taylor@example.com", "222333444"));

    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }

    @Override
    public Student save(Student student) {
        Long newId = (this.students.size() + 1L);
        student.setId(newId);
        this.students.add(student);
        return student;
    }

    @Override
    public String delete(Student student) {
        Student studentToDelete = this.students.stream()
                .filter(s -> s.getId().equals(student.getId()))
                .findFirst()
                .orElse(null);
        if (studentToDelete != null) {
            students.remove(studentToDelete);
            return "Student deleted successfully";
        }
        return "The student does not exist";
    }

    @Override
    public Student update(Student student) {
        // search for the object
        Student studentToUpdated = this.students.stream()
                .filter(s -> s.getId().equals(student.getId()))
                .findFirst()
                .orElse(null);

        if (studentToUpdated != null) {
            // modify and save the object
            students.remove(studentToUpdated);
            studentToUpdated.setFirstname(student.getFirstname());
            studentToUpdated.setLastname(student.getLastname());
            studentToUpdated.setEmail(student.getEmail());
            studentToUpdated.setPhone(student.getPhone());
            students.add(studentToUpdated);

            return studentToUpdated;
        }

        return student;
    }

    @Override
    public Student findById(Long id) {

        return this.students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
