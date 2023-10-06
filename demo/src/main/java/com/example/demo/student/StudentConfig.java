package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;


@Configuration
public class StudentConfig {
    Student student;

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            {
                Student Alex = Student.builder()
                        .dob(LocalDate.of(1998, Month.AUGUST,4))
                        .email("alex@gmail.com")
                        .name("Pavan")
                        .age(Period.between(LocalDate.of(1998, Month.AUGUST,4),LocalDate.now()).getYears())
                        .build();

                Student James = Student.builder()
                        .name("Kumar")
                        .email("james@gmail.com")
                        .dob(LocalDate.of(2002, Month.AUGUST,4))
                        .age(Period.between(LocalDate.of(2002, Month.AUGUST,4),LocalDate.now()).getYears())
                        .build();
                repository.saveAll(List.of(Alex, James));
            }
        };
    }

}

