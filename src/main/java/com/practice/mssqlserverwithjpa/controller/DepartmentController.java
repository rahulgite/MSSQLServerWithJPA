package com.practice.mssqlserverwithjpa.controller;

import com.practice.mssqlserverwithjpa.entity.Department;
import com.practice.mssqlserverwithjpa.error.DepartmentNotFoundException;
import com.practice.mssqlserverwithjpa.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl service;

    private final Logger LOGGER=
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/save")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        System.out.println(department);
        return service.saveDepartment(department);
    }

    @GetMapping("/get")
    public List<Department> getAllDept(){
        LOGGER.info("Inside getAllDept of DepartmentController");
        return service.getAllDept();
    }

    @GetMapping("get/{id}")
    public Department getDept(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        LOGGER.info("Inside getDept of DepartmentController");

        return service.getDept(deptId);
    }

    @DeleteMapping("delete/{id}")
    public String deleteDept(@PathVariable("id") Long deptId){
        LOGGER.info("Inside deleteDept of DepartmentController");

        service.deleteDept(deptId);
        return "Department deleted with ID "+deptId;
    }

    @PutMapping("update/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,
                                       @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");

        return service.updateDepartment(id,department);
    }

    @GetMapping("get/dept/{deptName}")
    public List<Department> getDepartment(@PathVariable("deptName") String deptName){
        LOGGER.info("Inside getDepartment of DepartmentController");

        return service.getDeptsByName(deptName);
    }
}
