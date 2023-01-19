package com.example.employeepayrollapp.DTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid Employee Name")
    public String name;
    @Pattern(regexp = "^(male|female)$", message = "Invalid Employee Name")
    public String gender;
    @Min(value = 500,message = "Minimum wage should be more than 500")
    public long salary;
    public String imagePath;
    @NotEmpty
    public String startDate;
    public String notes;
    public String department;
    public int employeeId;
public EmployeePayrollDTO(String name, String gender, long salary, String imagePath, String startDate, String notes,
                              String department, int employeeId) {
    super();
    this.name = name;
    this.gender = gender;
    this.salary = salary;
    this.imagePath = imagePath;
    this.startDate = startDate;
    this.notes = notes;
    this.department = department;
    this.employeeId = employeeId;
    }
}
