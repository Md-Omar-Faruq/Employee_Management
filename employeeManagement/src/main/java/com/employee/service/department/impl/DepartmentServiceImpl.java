package com.employee.service.department.impl;

import com.employee.entity.department.Department;
import com.employee.error.ResourceNotFoundException;
import com.employee.repository.department.DepartmentRepository;
import com.employee.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws ResourceNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new ResourceNotFoundException("Address Not Found With This Id: "+departmentId);
        }
        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        Department getDepartment = departmentRepository.findById(departmentId).get();
        if(getDepartment.getId().equals(departmentId)){
            departmentRepository.deleteById(departmentId);
            return getDepartment.getDepartmentName()+" Address Delete Successfully!!..";
        }

        return "Address Not Find With This Id"+departmentId;
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existingDept = departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            existingDept.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            existingDept.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            existingDept.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(existingDept);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
