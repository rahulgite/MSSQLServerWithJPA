package com.practice.mssqlserverwithjpa.repository;

import com.practice.mssqlserverwithjpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    List<Department> findAllByName(String deptName);
    List<Department> findAllByNameIgnoreCase(String deptName);

}
