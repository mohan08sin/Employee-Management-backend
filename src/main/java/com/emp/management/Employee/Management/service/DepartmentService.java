package com.emp.management.Employee.Management.service;

import com.emp.management.Employee.Management.dto.DepartmentDto;
import com.emp.management.Employee.Management.entity.Department;
import java.util.List;
public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);

    void deleteDepartment(Long departmentId);

}
