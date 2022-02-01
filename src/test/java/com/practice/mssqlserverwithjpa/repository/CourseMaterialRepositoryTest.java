package com.practice.mssqlserverwithjpa.repository;

import com.practice.mssqlserverwithjpa.entity.Course;
import com.practice.mssqlserverwithjpa.entity.CourseMaterial;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial(){
        Course course=Course.builder()
                .title("Java")
                .credit(50)
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMatrial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }

}