package com.practice.mssqlserverwithjpa.service;

import com.practice.mssqlserverwithjpa.entity.Department;
import com.practice.mssqlserverwithjpa.error.DepartmentNotFoundException;
import com.practice.mssqlserverwithjpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAllDept() {
        return repository.findAll();
    }

    @Override
    public Department getDept(Long deptId) throws DepartmentNotFoundException {

        Optional<Department> dept=
                repository.findById(deptId);

        if(!dept.isPresent()){
            throw  new DepartmentNotFoundException("Department not found with ID :"+deptId);
        }
        return dept.get();
    }

    @Override
    public void deleteDept(Long deptId) {
        repository.deleteById(deptId);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department dept=repository.findById(id).get();

        if(Objects.nonNull(department.getName()) &&
        !"".equalsIgnoreCase(department.getName())){
            dept.setName(department.getName());
        }

        if(Objects.nonNull(department.getCode()) &&
                !"".equalsIgnoreCase(department.getCode())){
            dept.setCode(department.getCode());
        }

        if(Objects.nonNull(department.getAddress()) &&
                !"".equalsIgnoreCase(department.getAddress())){
            dept.setAddress(department.getAddress());
        }
        return repository.save(dept);
    }

    @Override
    public List<Department> getDeptsByName(String deptName) {
        return repository.findAllByNameIgnoreCase(deptName);
    }
}
