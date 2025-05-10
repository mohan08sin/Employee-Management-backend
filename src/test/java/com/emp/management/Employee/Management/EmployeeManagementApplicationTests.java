package com.emp.management.Employee.Management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication
@EnableScheduling
public class EmployeeManagementApplicationTests {
	@Test
	void contextLoads() {
	}
	
    public static void main(String[] args) {
        SpringApplication.run(YourApp.class, args);
    }
}
