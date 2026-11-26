package com.barros.springframework.cruddemo;

import com.barros.springframework.cruddemo.dao.StudentDAO;
import com.barros.springframework.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
            //createStudent(studentDAO);

            //createMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            //queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        //Get list/student
        List<Student> students = studentDAO.findByLastName("Barros");

        //Display List
        for(Student student : students){
            System.out.println(student);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {
        //Get list of students
        List<Student> theStudents = studentDAO.findAll();

        //Display List
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        //Create Student
        System.out.println("Creating new Student Object ...");
        Student tempStudent = new Student("John", "cabral", "teste4@gmail.com");

        //Save the student
        System.out.println("Saving student ...");
        studentDAO.save(tempStudent);

        //Display the ID of the saved Student
        int theId = tempStudent.getId();
        System.out.println("Saved student student. Generated ID: " + theId);

        //Retrieve student based on the ID
        System.out.println("Retrieving student with id: " + theId);
        Student findStudent = studentDAO.findById(theId);

        //Display Student
        System.out.println("Found Student: " + findStudent);


    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //Create multiple students
        System.out.println("Creating new Student Object");
        Student tempStudent1 = new Student("Nicolas", "Barros", "teste1@gmail.com");
        Student tempStudent2 = new Student("Malu", "Momo", "teste2@gmail.com");
        Student tempStudent3 = new Student("Pedro", "Joses", "teste3@gmail.com");

        //Save the student objects
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        //Display id of te saved student
        System.out.println("Saved student. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student. Generated id: " + tempStudent3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
        //Create the student object
        System.out.println("Creating new Student Object");
        Student tempStudent = new Student("Nicolas", "Barros", "teste@gmail.com");

        //Save the student object
        studentDAO.save(tempStudent);

        //Display id of te saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
