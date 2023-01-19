package com.example.employeepayrollapp.Service;
import com.example.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.example.employeepayrollapp.Exception.EmployeePayrollException;
import com.example.employeepayrollapp.Model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private List<EmployeePayrollData>empPayrollList=new ArrayList<>();
 @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return empPayrollList;
}
@Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
    return empPayrollList.stream()
            .filter(empData -> empData.getEmployeeId() == empId).findFirst()
            .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
}
@Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollList.size()+1,employeePayrollDTO);
    empPayrollList.add(empData);
        return empData;
 }
@Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
    empData.setName(employeePayrollDTO.name);
    empData.setSalary(employeePayrollDTO.salary);
    empData.setImagePath(employeePayrollDTO.imagePath);
    empData.setEmployeeId(employeePayrollDTO.employeeId);
    empData.setStartDate(employeePayrollDTO.startDate);
    empData.setDepartment(employeePayrollDTO.department);
    empData.setNotes(employeePayrollDTO.notes);
    empPayrollList.set(empId - 1,empData);
        return empData;
}
 @Override
    public void deleteEmployeePayrollDTO(int empId) {
     empPayrollList.remove(empId - 1);
    }
}