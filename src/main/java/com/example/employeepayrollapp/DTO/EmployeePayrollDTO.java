package com.example.employeepayrollapp.DTO;
public class EmployeePayrollDTO {
 public String name;
 public int salary;
public EmployeePayrollDTO(String name, int salary) {
      super();
      this.name = name;
      this.salary = salary;
}
  @Override
   public String toString() {

    return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
    }
}
