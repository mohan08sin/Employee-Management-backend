package com.emp.management.Employee.Management.service;

import com.emp.management.Employee.Management.dto.EmployeeDto;
import com.emp.management.Employee.Management.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employee, EmployeeDto updateEmployee );

    void deleteEmployee(Long employeeId);


}
