package com.example.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeePayRollAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmployeePayRollAppApplication.class, args);
        log.info("Employee payroll app started.");
    }

}
