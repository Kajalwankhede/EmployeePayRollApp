package com.example.employeepayrollapp.Service;
import com.example.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.example.employeepayrollapp.Exception.EmployeePayrollException;
import com.example.employeepayrollapp.Model.EmployeePayrollData;
import com.example.employeepayrollapp.Repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    private List<EmployeePayrollData> empPayrollList = new ArrayList<>();
 @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
}

//Getting Employee Data by id
 @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with employeeId" + empId + "doesnt exixtes...!!"));
 }

//Creating an employee data
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    //Updating employee data by id
 @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeeEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(empData);

}

//Deleting employee data by employee id
 @Override
    public void deleteEmployeePayrollDTO(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
 }

 //getting employee data by department
@Override
    public List<EmployeePayrollData> getEmployeePayrollByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}
