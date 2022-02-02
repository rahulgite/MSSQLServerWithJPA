package com.practice.mssqlserverwithjpa.service;

import com.practice.mssqlserverwithjpa.entity.Department;
import com.practice.mssqlserverwithjpa.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   List<Department> getAllDept();

   Department getDept(Long deptId) throws DepartmentNotFoundException;

   void deleteDept(Long deptId);

   Department updateDepartment(Long id, Department department);

    List<Department> getDeptsByName(String deptName);
}
