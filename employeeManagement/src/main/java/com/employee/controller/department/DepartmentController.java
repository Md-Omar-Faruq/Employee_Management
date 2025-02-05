package com.employee.controller.department;

import com.employee.entity.department.Department;
import com.employee.error.ResourceNotFoundException;
import com.employee.service.department.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final Logger LOGGER = LoggerFactory.getLogger(Department.class);

    @Autowired
    private DepartmentService departmentService;


    // Create a new Address
    @PostMapping
    public Department createDepartment(@Valid @RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    // Find/Get Address using id
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws ResourceNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

}
