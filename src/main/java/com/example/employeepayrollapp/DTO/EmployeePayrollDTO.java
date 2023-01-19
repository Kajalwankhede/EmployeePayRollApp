package com.example.employeepayrollapp.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid Employee Name")
    public String name;
    @Pattern(regexp = "^(male|female)$", message = "Invalid Employee Name")
    public String gender;
    @Min(value = 500,message = "Minimum wage should be more than 500")
    public long salary;
    @NotBlank(message = "Imagepath cannot be empty")
    public String imagePath;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "start date should not be empty")
    public String startDate;
    @NotBlank(message = "Note cannot be empty")
    public String notes;
    @NotBlank(message = "Department cannot be empty")
    public String department;
    public int employeeId;

}
