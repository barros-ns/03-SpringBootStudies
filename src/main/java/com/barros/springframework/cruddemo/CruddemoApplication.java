package com.barros.springframework.cruddemo;

import com.barros.springframework.cruddemo.dao.StudentDAO;
import com.barros.springframework.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commnandLineRunner (StudentDAO studentDAO){
        return runner ->{
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        //Create the student object
        System.out.println("Creating new Student Object");
        Student tempStudent = new Student("Nicolas", "Barros", "teste@gmail.com");

        //Save the student object
        studentDAO.save(tempStudent);

        //Displau id of te saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
