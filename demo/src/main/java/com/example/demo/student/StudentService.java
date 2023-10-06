package com.example.demo.student;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Email Already used");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(int ID) {
        if (!studentRepository.existsById(ID)) {
            throw new IllegalStateException("Student with ID " + ID + " doesn't exist");
        }
        studentRepository.deleteById(ID);
    }

    @Transactional
    public void updateStudent(int ID, String email) {
        if (!studentRepository.existsById(ID)) {
            throw new IllegalStateException("Student with ID " + ID + " doesn't exist");
        }
        Student student=studentRepository.getById(ID);
        student.setEmail(email);
    }
}
