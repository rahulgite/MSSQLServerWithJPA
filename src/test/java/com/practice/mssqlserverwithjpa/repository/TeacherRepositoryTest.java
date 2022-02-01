package com.practice.mssqlserverwithjpa.repository;

import com.practice.mssqlserverwithjpa.entity.Course;
import com.practice.mssqlserverwithjpa.entity.CourseMaterial;
import com.practice.mssqlserverwithjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course1=Course.builder()
                .title(".NET")
                .credit(25)
                .build();

        Course course2=Course.builder()
                .title("SQL")
                .credit(25)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Shraddha")
                .lastName("G")
                //.courseList(Arrays.asList(course1,course2))
                .build();

        teacherRepository.save(teacher);
    }
}