package com.example.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayRollAppApplication {
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(EmployeePayRollAppApplication.class, args);
        log.info("Employee Payroll App started in {} Environment", context.getEnvironment().getProperty("environment"));

        log.info("Employee payroll DB user is {}",  context.getEnvironment().getProperty("spring.datasource.username"));
    }

}