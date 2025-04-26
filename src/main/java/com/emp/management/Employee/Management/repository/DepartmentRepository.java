package com.emp.management.Employee.Management.repository;

import com.emp.management.Employee.Management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department , Long> {

}
