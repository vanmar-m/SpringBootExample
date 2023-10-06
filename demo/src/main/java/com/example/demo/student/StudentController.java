package com.example.demo.student;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path="details")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void addingStudents(@RequestBody Student student){
     studentService.addStudent(student);
    }

    @DeleteMapping(path = "{ID}")
    public void deleteStudents(@PathVariable ("ID") int ID){
        studentService.deleteStudent(ID);
    }

    @PutMapping(path = "{ID}")
    public void updateStudent(@PathVariable("ID") int ID,@RequestParam(required = false) String email){
        studentService.updateStudent(ID,email);
    }

}



