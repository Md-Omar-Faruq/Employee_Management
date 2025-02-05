package com.employee.service.department;

import com.employee.entity.department.Department;
import com.employee.error.ResourceNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department createDepartment(Department department);

    public List<Department> getAllDepartment();

    public Department getDepartmentById(Long departmentId) throws ResourceNotFoundException;

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long id, Department department);

    public Department getDepartmentByName(String departmentName);
}
