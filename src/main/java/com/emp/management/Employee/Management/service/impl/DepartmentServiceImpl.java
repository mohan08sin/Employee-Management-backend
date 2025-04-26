package com.emp.management.Employee.Management.service.impl;

import com.emp.management.Employee.Management.dto.DepartmentDto;
import com.emp.management.Employee.Management.entity.Department;
import com.emp.management.Employee.Management.exception.ResourceNotFound;
import com.emp.management.Employee.Management.mapper.DepartmentMapper;
import com.emp.management.Employee.Management.repository.DepartmentRepository;
import com.emp.management.Employee.Management.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto){

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResourceNotFound("Department not exist with given id:" + departmentId)
        );

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department)-> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()->
                new ResourceNotFound("Department is not exists" + departmentId)
        );
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(()->
                new ResourceNotFound("Department not exist" + departmentId));
        departmentRepository.deleteById(departmentId);
    }

}
