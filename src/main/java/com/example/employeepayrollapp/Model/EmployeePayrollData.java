package com.example.employeepayrollapp.Model;
import com.example.employeepayrollapp.DTO.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "Name")
private String name;
 private String gender;
private long salary;
private String imagePath;
private String startDate;
private String notes;
private String department;
public EmployeePayrollData() {

}
public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
     this.employeeId = employeeId;
     this.name = employeePayrollDTO.name;
     this.salary = employeePayrollDTO.salary;
     this.imagePath = employeePayrollDTO.imagePath;
     this.gender = employeePayrollDTO.gender;
     this.department = employeePayrollDTO.department;
     this.notes = employeePayrollDTO.notes;
 }
@Override
    public String toString() {
        return "EmployeeRequestDao [name=" + name + ", gender=" + gender + ", salary=" + salary + ", imagePath="
                + imagePath + ", startDate=" + startDate + ", notes=" + notes + ", department=" + department + "]";
    }
}