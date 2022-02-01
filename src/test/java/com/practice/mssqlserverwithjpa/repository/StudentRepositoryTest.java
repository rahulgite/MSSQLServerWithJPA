package com.practice.mssqlserverwithjpa.repository;

import com.practice.mssqlserverwithjpa.entity.Gardian;
import com.practice.mssqlserverwithjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student= Student.builder().emailId("imgite@gmail.com")
                .firstName("Rahul")
                .lastName("Gite")
//                .gardianName("Priyanka")
//                .gardianEmail("Pk@gmail.com")
//                .gardianMobile("123465865")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGardian(){
        Gardian gardian=Gardian.builder().name("Siddesh")
                .mobile("131311131333")
                .email("sid@gmail.com")
                .build();

        Student student= Student.builder().emailId("imgite1@gmail.com")
                .firstName("Rahul")
                .lastName("Gite")
                .gardian(gardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getAllStudents(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void getAllStudentsByFirstName(){
        List<Student> studentList =
                studentRepository.findStudentByFirstName("Rahul");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByEmail(){
    Student student =
                studentRepository.getStudentByEmailId("imgite@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentNativeByEmail(){
        Student student =
                studentRepository.getStudentNativeByEmailId("imgite@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentNativeNamedByEmail(){
        Student student =
                studentRepository.getStudentNativeNamedByEmailId("imgite@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNamedByEmail(){
       Integer i=-1;
                i=studentRepository.updateStudentNameByEmailID("RG","imgite@gmail.com");
        System.out.println(i);
    }

    @Test
    public void getStudentNameByEmail(){
        String student =
                studentRepository.getStudentNameByEmailId("imgite@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getAllStudentsByFirstNameContaining(){
        List<Student> studentList =
                studentRepository.findStudentByFirstNameContaining("hul");
        System.out.println(studentList);
    }

    @Test
    public void getAllStudentsByGardianName(){
        List<Student> studentList =
                studentRepository.findByGardianName("Siddesh");
        System.out.println(studentList);
    }
}