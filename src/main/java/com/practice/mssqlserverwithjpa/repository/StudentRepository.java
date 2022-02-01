package com.practice.mssqlserverwithjpa.repository;

import com.practice.mssqlserverwithjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findStudentByFirstName(String fristName);
    public List<Student> findStudentByFirstNameContaining(String fristName);
    public List<Student> findByGardianName(String name);

    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentNameByEmailId(String emailId);

    //Native SQL Query
    @Query(
            value="Select * from Student where email_id=?1",
            nativeQuery = true
    )
    Student getStudentNativeByEmailId(String emailId);

    //Native Named Parameter SQL Query
    @Query(
            value="Select * from Student where email_id=:emailId",
            nativeQuery = true
    )
    Student getStudentNativeNamedByEmailId(@Param("emailId") String emailId);

    // Update
    @Modifying
    @Transactional
    @Query(
            value = "update Student set first_name=?1 where email_id=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailID(String firstName,String emailId);

}
