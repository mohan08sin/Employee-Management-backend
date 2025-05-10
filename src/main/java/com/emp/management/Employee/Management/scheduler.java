package com.emp.management.Employee.Management;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DatabaseKeepAlive {

    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(fixedRate = 300000) // Every 5 minutes (300,000 ms)
    public void pingDatabase() {
        try {
            entityManager.createNativeQuery("SELECT 1").getSingleResult();
            System.out.println("Database pinged successfully");
        } catch (Exception e) {
            System.err.println("Database ping failed: " + e.getMessage());
        }
    }
}
