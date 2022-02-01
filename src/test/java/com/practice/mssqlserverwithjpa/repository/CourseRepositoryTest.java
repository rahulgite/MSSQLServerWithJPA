package com.practice.mssqlserverwithjpa.repository;

import com.practice.mssqlserverwithjpa.entity.Course;
import com.practice.mssqlserverwithjpa.entity.Gardian;
import com.practice.mssqlserverwithjpa.entity.Student;
import com.practice.mssqlserverwithjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void getAllCourses(){
        List<Course> courseList=courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourses(){
        Teacher teacher=Teacher.builder()
                .firstName("Priyanka")
                .lastName("G")
                .build();
        Course course=Course.builder()
                .credit(5)
                .title("JPA")
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable page1=
                PageRequest.of(0,2);
        Pageable page2=
                PageRequest.of(1,2);
        List<Course> courses=
                courseRepository.findAll(page1).getContent();

        Long totalElements=
                courseRepository.findAll(page1).getTotalElements();
        System.out.println("Total Elements"+totalElements);

        Long totalPages=
                Long.valueOf(courseRepository.findAll(page1).getTotalPages());
        System.out.println("Total Pages"+totalPages);

        System.out.println(courses);
    }

    @Test
    public void findAllSort(){
        Pageable sortByTitle=PageRequest.of(0,4, Sort.by("title"));
        Pageable sortByCreditDec=PageRequest.of(0,4, Sort.by("credit").descending());
        Pageable sortByTitleAndCredit=PageRequest.of(0,4, Sort.by("title")
                .and(Sort.by("credit")));

        List<Course> courses=
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("sort By Title"+courses);

        courses=
                courseRepository.findAll(sortByCreditDec).getContent();
        System.out.println("sort By Credit Decending"+courses);

        courses=
                courseRepository.findAll(sortByTitleAndCredit).getContent();
        System.out.println("sort By Title And Credit"+courses);
    }

    @Test
    public void getTitleContaining(){
        Pageable page1=
                PageRequest.of(0,10);

        List<Course> courses=courseRepository.findByTitleContaining("J",page1).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Sachin")
                .lastName("M")
                .build();

        Gardian gardian=Gardian.builder().name("Mai")
                .mobile("32322332")
                .email("mai@gmail.com")
                .build();

        Student student1= Student.builder().emailId("rg@gmail.com")
                .firstName("RAH")
                .lastName("Git")
                .gardian(gardian)
                .build();

        Course course=Course.builder()
                .title("Jasmine")
                .credit(20)
                .teacher(teacher)
                .students(Arrays.asList(student1))
                .build();

        courseRepository.save(course);
    }
}