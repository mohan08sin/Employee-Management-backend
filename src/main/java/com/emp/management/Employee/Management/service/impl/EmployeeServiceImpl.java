package com.emp.management.Employee.Management.service.impl;

import com.emp.management.Employee.Management.dto.EmployeeDto;
import com.emp.management.Employee.Management.entity.Department;
import com.emp.management.Employee.Management.entity.Employee;
import com.emp.management.Employee.Management.exception.ResourceNotFound;
import com.emp.management.Employee.Management.mapper.EmployeeMapper;
import com.emp.management.Employee.Management.repository.DepartmentRepository;
import com.emp.management.Employee.Management.repository.EmployeeRepository;
import com.emp.management.Employee.Management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {


        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Department department = departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(()->
                new ResourceNotFound("Department not exist" + employeeDto.getDepartmentId()));
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()->
                        new ResourceNotFound("Employee Not exists with given id:" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFound("Employee is not exists with given id:"+ employeeId)
        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Department department = departmentRepository.findById(updateEmployee.getDepartmentId()).orElseThrow(()->
                new ResourceNotFound("Department not exist" + updateEmployee.getDepartmentId()));
        employee.setDepartment(department);

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFound("Employee is not exists with given id:"+ employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }


}
