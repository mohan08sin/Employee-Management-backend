package com.emp.management.Employee.Management.mapper;

import com.emp.management.Employee.Management.dto.EmployeeDto;
import com.emp.management.Employee.Management.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId()
        );
    };

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return  employee;
    }
}
