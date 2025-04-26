package com.emp.management.Employee.Management.repository;

import com.emp.management.Employee.Management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
