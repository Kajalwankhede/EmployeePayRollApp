package com.example.employeepayrollapp.Model;
import com.example.employeepayrollapp.DTO.EmployeePayrollDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

public @Data class EmployeePayrollData {
private String name;
 private String gender;
private long salary;
private String imagePath;
private String startDate;
private String notes;
private String department;
 private int employeeId;
 public EmployeePayrollData() {

}
public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
     this.employeeId = employeeId;
     this.name = employeePayrollDTO.getName();
     this.salary = employeePayrollDTO.getSalary();
     this.imagePath = employeePayrollDTO.getImagePath();
     this.gender = employeePayrollDTO.getGender();
     this.department = employeePayrollDTO.getDepartment();
     this.notes = employeePayrollDTO.getNotes();
 }
@Override
    public String toString() {
        return "EmployeeRequestDao [name=" + name + ", gender=" + gender + ", salary=" + salary + ", imagePath="
                + imagePath + ", startDate=" + startDate + ", notes=" + notes + ", department=" + department + "]";
    }
}